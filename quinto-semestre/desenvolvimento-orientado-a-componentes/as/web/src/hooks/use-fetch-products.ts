import { useEffect, SetStateAction } from "react";
import axios from "axios";

import { ProductType } from "../types/product.type";

export function useFetchProducts(
  callback: (value: SetStateAction<ProductType[]>) => void
) {
  useEffect(() => {
    async function getProducts() {
      try {
        const response = await axios.get(
          `${import.meta.env.VITE_API_BASE_URL}/product`,
          {
            withCredentials: true,
          }
        );
        callback(response.data.products);
      } catch (error) {
        callback([]);
      }
    }
    getProducts();
  }, []);
}
