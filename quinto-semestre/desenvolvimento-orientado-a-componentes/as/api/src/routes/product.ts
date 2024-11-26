import { randomUUID } from "node:crypto";

import { FastifyInstance } from "fastify";
import z from "zod";
import {
  createProduct,
  findManyProduct,
  findUniqueProduct,
  summaryProduct,
} from "../services/product";
import { checkSessionId } from "./middlewares/check-session-id";

export async function productRoutes(app: FastifyInstance) {
  app.post("/", async (request, reply) => {
    const createProductSchema = z.object({
      name: z.string(),
      price: z.number(),
      description: z.string().optional(),
      image: z.string(),
    });

    const body = createProductSchema.parse(request.body);

    let sessionId = request.cookies.sessionId;
    if (!sessionId) {
      sessionId = randomUUID();

      const sevenDaysInSeconds = 60 * 60 * 24 * 7;
      reply.setCookie("sessionId", sessionId, {
        path: "/",
        maxAge: sevenDaysInSeconds,
      });
    }

    await createProduct({
      ...body,
      description: body.description,
      session_id: sessionId,
    });

    return reply.status(201).send();
  });

  app.get(
    "/",
    {
      preHandler: [checkSessionId],
    },
    async (request) => {
      const { sessionId } = request.cookies;
      return await findManyProduct(sessionId!);
    }
  );

  app.get(
    "/:id",
    {
      preHandler: [checkSessionId],
    },
    async (request) => {
      const getUniqueProductParamSchema = z.object({
        id: z.string().uuid(),
      });
      const { sessionId } = request.cookies;

      const { id } = getUniqueProductParamSchema.parse(request.params);
      return await findUniqueProduct(id, sessionId!);
    }
  );

  app.get(
    "/summary",
    {
      preHandler: [checkSessionId],
    },
    async (request) => {
      const { sessionId } = request.cookies;
      return await summaryProduct(sessionId!);
    }
  );
}
