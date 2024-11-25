import { randomUUID } from "node:crypto";
import { knex } from "../../database";

type CreateTransactionData = {
    title: string;
    amount: number;
    type: "credit" | "debit";
    session_id: string;
}

export async function createTransaction({
    title,
    amount,
    type,
    session_id
}: CreateTransactionData): Promise<void> {
    await knex("transactions").insert({
        id: randomUUID(),
        amount: (type === "credit") ? amount : amount * -1,
        title,
        session_id
    });
}