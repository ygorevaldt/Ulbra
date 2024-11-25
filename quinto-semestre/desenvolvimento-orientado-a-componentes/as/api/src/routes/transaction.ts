import { randomUUID } from "node:crypto";

import { FastifyInstance } from "fastify";
import z from "zod";
import {
    createTransaction,
    findManyTransaction,
    findUniqueTransaction,
    summaryTransaction
} from "../services/transaction";
import { checkSessionId } from "./middlewares/check-session-id";

export async function transactionRoutes(app: FastifyInstance) {
    app.post("/", async (request, reply) => {
        const createTransactionSchema = z.object({
            title: z.string(),
            amount: z.number(),
            type: z.enum(["credit", "debit"])
        });

        const body = createTransactionSchema.parse(request.body);

        let sessionId = request.cookies.sessionId;
        if (!sessionId) {
            sessionId = randomUUID();

            const sevenDaysInSeconds = 60 * 60 * 24 * 7;
            reply.setCookie("sessionId", sessionId, {
                path: "/",
                maxAge: sevenDaysInSeconds
            });
        }

        await createTransaction({ ...body, session_id: sessionId });

        return reply.status(201).send();
    });

    app.get("/", {
        preHandler: [checkSessionId]
    }, async (request) => {
        const { sessionId } = request.cookies;
        return await findManyTransaction(sessionId!);
    });

    app.get("/:id", {
        preHandler: [checkSessionId]
    }, async (request) => {
        const getUniqueTransactionParamSchema = z.object({
            id: z.string().uuid()
        });
        const { sessionId } = request.cookies;

        const { id } = getUniqueTransactionParamSchema.parse(request.params);
        return await findUniqueTransaction(id, sessionId!);
    });

    app.get("/summary", {
        preHandler: [checkSessionId]
    }, async (request) => {
        const { sessionId } = request.cookies;
        return await summaryTransaction(sessionId!);
    });
}