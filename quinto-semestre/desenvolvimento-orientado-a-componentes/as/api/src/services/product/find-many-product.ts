import { knex } from "../../database";

export async function findManyProduct(sessionId: string) {
  const products = await knex("product")
    .where("session_id", sessionId)
    .select();

  return { products };
}
