import { knex } from "../../src/database";

export async function getTables() {
    const tables = await knex.raw(`
        SELECT name 
        FROM sqlite_master 
        WHERE type='table';
    `);

    console.log("tables", tables);

    return tables;
}