import { useState } from "react";
import { Page } from "../../components/page";

import styles from "./styles.module.css";
import { ProductType } from "../../types/product.type";
import { useFetchProducts } from "../../hooks/use-fetch-products";
import { ProductsList } from "../../components/products-list";

export function Products() {
  const [products, setProducts] = useState<ProductType[]>([]);
  useFetchProducts(setProducts);

  return (
    <Page>
      <header className={styles.headerContainer}>
        <h1>Página Produtos</h1>
        <p>
          Lorem ipsum dolor, sit amet consectetur adipisicing elit. Iste rerum
          fugiat quidem quam nostrum placeat, dolorem amet asperiores aperiam
          pariatur assumenda sequi veritatis perspiciatis explicabo porro totam
          repellat ducimus minima.
        </p>
      </header>
      <ProductsList products={products} />
    </Page>
  );
}
