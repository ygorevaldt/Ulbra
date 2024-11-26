//eslint-disable-next-line
import { Knex } from "knes";

declare module "knex/types/tables" {
  export interface Tables {
    product: {
      id: string;
      name: string;
      price: number;
      description?: string;
      image: string;
      created_at: string;
      updated_at?: string;
      session_id: string;
    };
  }
}
