import type { Knex } from "knex";

export async function up(knex: Knex): Promise<void> {
  await knex.schema.createTable("product", (table) => {
    table.uuid("id").primary();
    table.text("name").notNullable();
    table.decimal("price", 10, 2).notNullable();
    table.text("description");
    table.text("image").notNullable();
    table.timestamp("created_at").defaultTo(knex.fn.now).notNullable();
    table.timestamp("deleted_at");
  });
}

export async function down(knex: Knex): Promise<void> {
  await knex.schema.dropTable("product");
}
