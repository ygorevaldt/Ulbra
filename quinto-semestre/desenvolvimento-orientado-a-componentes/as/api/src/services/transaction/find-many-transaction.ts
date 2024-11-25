import { knex } from "../../database";

export async function findManyTransaction(sessionId: string) {
    const transactions = await knex("transactions")
        .where("session_id", sessionId)
        .select();

    return { transactions };
}