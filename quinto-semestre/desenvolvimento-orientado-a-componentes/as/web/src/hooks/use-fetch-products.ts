import { useEffect, SetStateAction } from "react";
import axios from "axios";

import { ProductType } from "../types/product.type";

export function useFetchProducts(
  callback: (value: SetStateAction<ProductType[]>) => void
) {
  useEffect(() => {
    async function getProducts() {
      try {
        const response = await axios.get("http://localhost:3333/product", {
          withCredentials: true,
        });
        callback(response.data.products);
      } catch (error) {
        callback([]);
      }
    }
    getProducts();
  }, []);
}
