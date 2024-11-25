import { knex } from "../../database";

export async function findUniqueTransaction(id: string, sessionId: string) {
    const transaction = await knex("transactions")
        .where({
            "id": id,
            "session_id": sessionId
        })
        .select()
        .first();

    return { transaction };
}