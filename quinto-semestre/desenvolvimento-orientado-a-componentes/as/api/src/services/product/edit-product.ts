import { knex } from "../../database";

type EditProductData = {
  id: string;
  name?: string;
  price?: number;
  description?: string;
  image?: string;
  session_id: string;
};

export async function editProduct({
  id,
  name,
  price,
  description,
  image,
  session_id,
}: EditProductData) {
  const currentProduct = await knex("product").where({ id }).select().first();

  if (!currentProduct) throw new Error("Product is not alredy registred");

  const newProduct = Object.assign(currentProduct, {
    id,
    name,
    price,
    description,
    image,
    session_id,
    updated_at: new Date().toISOString(),
  });

  await knex("product").where({ id }).update(newProduct);
}
