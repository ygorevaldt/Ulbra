import type { Knex } from "knex";

export async function up(knex: Knex): Promise<void> {
  await knex.schema.alterTable("product", (table) => {
    table.renameColumn("deleted_at", "updated_at");
  });
}

export async function down(knex: Knex): Promise<void> {
  await knex.schema.alterTable("product", (table) => {
    table.renameColumn("updated_at", "deleted_at");
  });
}
