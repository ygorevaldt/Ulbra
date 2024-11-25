import type { Knex } from "knex";

export async function up(knex: Knex): Promise<void> {
    knex.schema.alterTable("transactions", (table) => {
        table.uuid("session_id").after("id").index(); //criando indice para deixar as querys mais performáticas
    });
}

export async function down(knex: Knex): Promise<void> {
    knex.schema.alterTable("transactions", (table) => {
        table.dropColumn("session_id");
    });
}

