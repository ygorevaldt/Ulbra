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
