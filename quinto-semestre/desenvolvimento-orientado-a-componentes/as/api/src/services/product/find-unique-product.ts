import { knex } from "../../database";

export async function findUniqueProduct(id: string, sessionId: string) {
  const product = await knex("product")
    .where({
      id: id,
      session_id: sessionId,
    })
    .select()
    .first();

  return { product };
}
