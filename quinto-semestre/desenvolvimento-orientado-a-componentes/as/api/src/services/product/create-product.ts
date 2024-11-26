import { randomUUID } from "node:crypto";
import { knex } from "../../database";

type CreateProductData = {
  name: string;
  price: number;
  description?: string;
  image: string;
  session_id: string;
};

export async function createProduct({
  name,
  price,
  description,
  image,
  session_id,
}: CreateProductData): Promise<void> {
  await knex("product").insert({
    id: randomUUID(),
    name,
    price,
    description: description ?? "",
    image,
    created_at: new Date().toISOString(),
    deleted_at: "",
    session_id,
  });
}
