import { execSync } from "node:child_process";

import { expect, it, beforeAll, afterAll, describe, beforeEach } from "vitest";
import request from "supertest";

import { app } from "../../src/app";

describe("Product routes", () => {
  beforeAll(async () => {
    await app.ready();
  });

  afterAll(async () => {
    await app.close();
  });

  beforeEach(() => {
    execSync("npm run knex migrate:rollback --all");
    execSync("npm run knex migrate:latest");
  });

  const createProductBody = {
    name: "Produto 01",
    price: 5000,
    image:
      "https://cdn.awsli.com.br/954/954868/produto/68626025/5d150286dc.jpg",
  };

  it("should be able to create a new product", async () => {
    const response = await request(app.server)
      .post("/product")
      .send(createProductBody);

    expect(response.statusCode).toEqual(201);
  });

  it("should be able to list all products", async () => {
    const createProductResponse = await request(app.server)
      .post("/product")
      .send(createProductBody);

    const cookies = createProductResponse.get("Set-Cookie");

    const listProductResponse = await request(app.server)
      .get("/product")
      .set("Cookie", cookies!)
      .expect(200);

    expect(listProductResponse.body.products).toEqual([
      expect.objectContaining({
        name: createProductBody.name,
      }),
    ]);
  });

  it("should be able to get a specific product", async () => {
    const createProductResponse = await request(app.server)
      .post("/product")
      .send(createProductBody);

    const cookies = createProductResponse.get("Set-Cookie");

    const listProductResponse = await request(app.server)
      .get("/product")
      .set("Cookie", cookies!)
      .expect(200);

    const productId = listProductResponse.body.products[0].id;

    const getProductResponse = await request(app.server)
      .get(`/product/${productId}`)
      .set("Cookie", cookies!)
      .expect(200);

    expect(getProductResponse.body.product).toEqual(
      expect.objectContaining({
        name: createProductBody.name,
      })
    );
  });

  it("should be able to get a products summary", async function () {
    const cookies = [
      `sessionId=12126978-3a71-4caa-90d8-475242e10718; Max-Age604800; Path=/; SameSite=Lax`,
    ];

    const [createProductResponse1, createProductResponse2] = await Promise.all([
      request(app.server)
        .post("/product")
        .set("Cookie", cookies)
        .send(createProductBody),
      request(app.server)
        .post("/product")
        .set("Cookie", cookies)
        .send({ ...createProductBody, name: "Produto 2" }),
    ]);

    const findSummaryProductsResponse = await request(app.server)
      .get("/product/summary")
      .set("Cookie", cookies)
      .expect(200);

    expect(findSummaryProductsResponse.body.summary.registred_total).toEqual(2);
  });

  it("should be able to delete a specific product", async () => {
    const cookies = [
      `sessionId=12126978-3a71-4caa-90d8-475242e10718; Max-Age604800; Path=/; SameSite=Lax`,
    ];

    await Promise.all([
      request(app.server)
        .post("/product")
        .set("Cookie", cookies)
        .send(createProductBody),
      request(app.server)
        .post("/product")
        .set("Cookie", cookies)
        .send({ ...createProductBody, name: "Produto 2" }),
    ]);

    const listProductResponse = await request(app.server)
      .get("/product")
      .set("Cookie", cookies!)
      .expect(200);

    const productId = listProductResponse.body.products[0].id;

    await request(app.server)
      .delete(`/product/${productId}`)
      .set("Cookie", cookies!)
      .expect(200);

    const newListProductResponse = await request(app.server)
      .get("/product")
      .set("Cookie", cookies!)
      .expect(200);

    expect(newListProductResponse.body.products.length).toEqual(1);
    expect(newListProductResponse.body.products).not.toEqual(
      expect.objectContaining({
        id: productId,
      })
    );
  });

  it.only("should be able to get a specific product", async () => {
    const createProductResponse = await request(app.server)
      .post("/product")
      .send(createProductBody);

    const cookies = createProductResponse.get("Set-Cookie");

    const listProductResponse = await request(app.server)
      .get("/product")
      .set("Cookie", cookies!)
      .expect(200);

    const product = listProductResponse.body.products[0];

    await request(app.server)
      .put(`/product/${product.id}`)
      .set("Cookie", cookies!)
      .send(Object.assign(product, { name: "new name" }))
      .expect(200);

    const getProductResponse = await request(app.server)
      .get(`/product/${product.id}`)
      .set("Cookie", cookies!)
      .expect(200);

    console.log(getProductResponse.body);

    expect(getProductResponse.body.product).toEqual(
      expect.objectContaining({
        name: "new name",
      })
    );
  });
});
