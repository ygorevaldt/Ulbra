import fastify from "fastify";
import cors from "@fastify/cors";
import cookie from "@fastify/cookie";

import { productRoutes } from "./routes/product";

export const app = fastify();

app.register(cors, {
  origin: "http://localhost:5173",
  credentials: true,
});

app.register(cookie);
app.register(productRoutes, { prefix: "/product" });
