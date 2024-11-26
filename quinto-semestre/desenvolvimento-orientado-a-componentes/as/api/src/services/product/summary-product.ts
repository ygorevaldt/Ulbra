import { knex } from "../../database";

export async function summaryProduct(sessionId: string) {
  const summary = await knex("product")
    .where({ session_id: sessionId })
    .count("id", { as: "registred_total" })
    .first();

  return { summary };
}
