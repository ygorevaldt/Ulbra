import { ProductType } from "../../types/product.type";
import styles from "./styles.module.css";

type ProductsListProps = {
  products: ProductType[];
};

export function ProductsList({ products }: ProductsListProps) {
  return (
    <ul className={styles.ulContainer}>
      {products.map((product) => {
        return (
          <li key={product.id}>
            <span>Nome: {product.name}</span>
          </li>
        );
      })}
    </ul>
  );
}
