import { useState } from "react";
import { Page } from "../../components/page";

import styles from "./styles.module.css";
import { ProductType } from "../../types/product.type";
import { useFetchProducts } from "../../hooks/use-fetch-products";
import { ProductsTable } from "../../components/products-table";
import { NavLink } from "react-router-dom";

export function Products() {
  const [products, setProducts] = useState<ProductType[]>([]);
  useFetchProducts(setProducts);

  return (
    <Page>
      <header className={styles.headerContainer}>
        <h1>Produtos</h1>
        <p>Cadastre e gerêncie seus produtos de forma simples e fácil</p>
      </header>
      <main className={styles.mainContainer}>
        <div
          className={`
          ${styles.registerProductContainer} 
          ${!products[0] ? styles.justifyBetween : ""}
        `}
        >
          {!products[0] && (
            <p className={styles.noProductRegistred}>
              Nenhum produto cadastrado
            </p>
          )}
          <NavLink
            className={styles.registerProductButton}
            to={"/products/register"}
          >
            Cadastrar
          </NavLink>
        </div>
        {products[0] && <ProductsTable productsList={products} />}
      </main>
    </Page>
  );
}
