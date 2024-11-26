import { useEffect, SetStateAction } from "react";
import { ProductType } from "../types/product.type";

export function useFetchProducts(
  callback: (value: SetStateAction<ProductType[]>) => void
) {
  useEffect(() => {
    async function getProducts() {
      try {
        const response = await fetch("http://localhost:3333/product");
        const responseJson = await response.json();
        callback(responseJson.products);
      } catch (error) {
        console.error(error);
        callback([]);
      }
    }

    getProducts();
  }, []);
}
