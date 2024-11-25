import { knex } from "../../src/database";

export async function getTableEstructure(tableName: string) {
    const tableEstructure = await knex.raw(`PRAGMA table_info(${tableName});`);
    console.log("table estructure", tableEstructure);

    return tableEstructure;
}