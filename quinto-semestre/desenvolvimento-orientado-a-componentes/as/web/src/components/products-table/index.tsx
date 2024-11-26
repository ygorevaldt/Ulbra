import { useState } from "react";
import { PiPencilLineBold, PiTrashBold } from "react-icons/pi";
import { NavLink } from "react-router-dom";
import axios from "axios";

import { ProductType } from "../../types/product.type";
import { successAlert, errorAlert } from "../../utils/sweetalert";

import styles from "./styles.module.css";

type ProductsListProps = {
  productsList: ProductType[];
};

export function ProductsTable({ productsList }: ProductsListProps) {
  const [products, setProducts] = useState<ProductType[]>(productsList);

  async function handleDeleteProduct(id: string) {
    try {
      await axios.delete(`${import.meta.env.VITE_API_BASE_URL}/product/${id}`, {
        withCredentials: true,
      });
      successAlert("Produto removido com sucesso");

      const productsWithoutDeleted = products.filter(
        (product) => product.id !== id
      );
      setProducts(productsWithoutDeleted);
    } catch (error) {
      console.error(error);
      errorAlert("Erro ao remover produto");
    }
  }

  function handleNavigateToEditProductPage(product: ProductType) {
    localStorage.setItem("productToEdit", JSON.stringify(product));
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
                <NavLink
                  to={"/products/edit"}
                  onClick={() => handleNavigateToEditProductPage(product)}
                  title="Editar"
                >
                  {<PiPencilLineBold size={20} />}
                </NavLink>
                <button onClick={() => handleDeleteProduct(id)} title="Excluir">
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
