import { knex } from "../../database";

export async function deleteProduct(id: string, sessionId: string) {
  await knex("product")
    .where({
      id: id,
      session_id: sessionId,
    })
    .delete();
}
