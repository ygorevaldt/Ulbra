import { knex } from "../../database";

export async function findManyProduct(sessionId: string) {
  const product = await knex("product").where("session_id", sessionId).select();

  return { product };
}
