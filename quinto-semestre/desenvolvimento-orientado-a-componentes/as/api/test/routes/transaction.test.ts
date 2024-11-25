import { execSync } from "node:child_process";

import { expect, it, beforeAll, afterAll, describe, beforeEach } from "vitest";
import request from "supertest";

import { app } from "../../src/app";

describe("Transaction routes", () => {
    beforeAll(async () => {
        await app.ready();
    });

    afterAll(async () => {
        await app.close();
    });

    beforeEach(() => {
        execSync("npm run knex migrate:rollback --all");
        execSync("npm run knex migrate:latest");
    });

    it("should be able to create a new transaction", async () => {
        const response = await request(app.server)
            .post("/transactions")
            .send({
                title: "Transação de teste",
                amount: 1000,
                type: "debit"
            });

        expect(response.statusCode).toEqual(201);
    });

    it("should be able to list all transactions", async () => {
        const createTransactionResponse = await request(app.server)
            .post("/transactions")
            .send({
                title: "Transação de teste",
                amount: 1000,
                type: "credit"
            });

        const cookies = createTransactionResponse.get("Set-Cookie");

        const listTransactionResponse = await request(app.server)
            .get("/transactions")
            .set("Cookie", cookies!)
            .expect(200);

        expect(listTransactionResponse.body.transactions).toEqual([
            expect.objectContaining({
                title: "Transação de teste",
                amount: 1000
            })
        ]);
    });

    it("should be able to get a specific transaction", async () => {
        const createTransactionResponse = await request(app.server)
            .post("/transactions")
            .send({
                title: "Transação de teste",
                amount: 1000,
                type: "credit"
            });

        const cookies = createTransactionResponse.get("Set-Cookie");

        const listTransactionResponse = await request(app.server)
            .get("/transactions")
            .set("Cookie", cookies!)
            .expect(200);

        const transactionId = listTransactionResponse.body.transactions[0].id;

        const getTransactionResponse = await request(app.server)
            .get(`/transactions/${transactionId}`)
            .set("Cookie", cookies!)
            .expect(200);

        expect(getTransactionResponse.body.transaction).toEqual(
            expect.objectContaining({
                title: "Transação de teste",
                amount: 1000
            })
        );
    });

    it("should be able to get a specific transaction", async () => {
        const creditTransaction = {
            title: "Transação de crédito",
            amount: 5000,
            type: "credit"
        };

        const debitTransaction = {
            title: "Transação de débito",
            amount: 2000,
            type: "debit"
        };

        const creditTransactionResponse = await request(app.server)
            .post("/transactions")
            .send(creditTransaction);

        const cookies = creditTransactionResponse.get("Set-Cookie");

        await request(app.server)
            .post("/transactions")
            .set("Cookie", cookies!)
            .send(debitTransaction);

        const summaryResponse = await request(app.server)
            .get("/transactions/summary")
            .set("Cookie", cookies!)
            .expect(200);

        expect(summaryResponse.body.summary).toEqual(
            expect.objectContaining({
                amount: 3000
            })
        );
    });

});



