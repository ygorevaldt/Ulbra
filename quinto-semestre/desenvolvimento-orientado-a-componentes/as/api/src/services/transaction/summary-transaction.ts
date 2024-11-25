import { knex } from "../../database";

export async function summaryTransaction(sessionId: string) {
    const summary = await knex("transactions")
        .where({ session_id: sessionId })
        .sum("amount", { as: "amount" })
        .first();

    return { summary };
}