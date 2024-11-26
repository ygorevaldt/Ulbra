import fastify from "fastify";
import cors from "@fastify/cors";
import cookie from "@fastify/cookie";

import { productRoutes } from "./routes/product";

export const app = fastify();

app.register(cors, { origin: "*" });

app.register(cookie);
app.register(productRoutes, { prefix: "/product" });
