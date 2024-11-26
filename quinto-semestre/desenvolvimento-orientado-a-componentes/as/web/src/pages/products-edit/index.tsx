import { useEffect, useState } from "react";
import { ProductType } from "../../types/product.type";
import { ProductForm } from "../../components/product-form";

import styles from "./styles.module.css";

export function ProductsEdit() {
  const [product, setProduct] = useState<ProductType | null>(null);

  useEffect(() => {
    const productToEdit = localStorage.getItem("productToEdit");
    if (productToEdit === null) return;

    const productJson = JSON.parse(productToEdit);
    console.log("productJson", productJson);
    setProduct(productJson);
  }, []);

  return (
    <div className={styles.productsEditContainer}>
      <header className={styles.headerContainer}>
        <h2>Edição de Produto</h2>
        <img
          className={styles.productImage}
          src={product?.image}
          alt="imagem do produto"
        />
      </header>
      <main>
        {product !== null ? (
          <ProductForm product={product} isEditMode={true} />
        ) : (
          <p>Produto não encontrado</p>
        )}
      </main>
    </div>
  );
}
