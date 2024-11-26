import { PiPencilLineBold, PiTrashBold } from "react-icons/pi";

import { ProductType } from "../../types/product.type";
import styles from "./styles.module.css";
import { NavLink } from "react-router-dom";

type ProductsListProps = {
  products: ProductType[];
};

export function ProductsTable({ products }: ProductsListProps) {
  async function handleDeleteProduct(id: string) {
    console.log("Deletando produto: ", id);
  }

  return (
    <table className={styles.productTable}>
      <thead>
        <tr>
          <th>Nome</th>
          <th>Descrição</th>
          <th>Preço</th>
          <th className={styles.actionButtonHeader}>Ações</th>
        </tr>
      </thead>
      <tbody>
        {products.map((product) => {
          const { id, name, description, price } = product;
          return (
            <tr key={id}>
              <td>{name}</td>
              <td>{description ? description : "N/A"}</td>
              <td>{price}</td>
              <td className={styles.actionButtons}>
                <NavLink to={"/products/edit"}>
                  {<PiPencilLineBold size={20} />}
                </NavLink>
                <button onClick={() => handleDeleteProduct(id)}>
                  {<PiTrashBold size={20} />}
                </button>
              </td>
            </tr>
          );
        })}
      </tbody>
    </table>
  );
}
