import { NavLink, useNavigate } from "react-router-dom";
import { z as zod } from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import axios from "axios";

import styles from "./styles.module.css";
import { ProductType } from "../../types/product.type";
import { errorAlert, successAlert } from "../../utils/sweetalert";
import { LoadingSpinner } from "../loading-spinner";
import { useState } from "react";

const newProductFormValidationSchema = zod.object({
  name: zod
    .string()
    .min(1, "Informe o nome do produto")
    .max(50, "O nome do produto deve ter no máximo 50 caracteres"),
  price: zod.number().min(0.01, "Informe o preço do produto"),
  description: zod.string().optional(),
  image: zod
    .string()
    .min(1, "Informe a URL da imagem do produto")
    .max(255, "A da imagem do produto é URL muito longa"),
});

type NewProductFormData = zod.infer<typeof newProductFormValidationSchema>;

type ProductFormProps = {
  product?: ProductType;
  isEditMode?: boolean;
};

export function ProductForm({ product, isEditMode }: ProductFormProps) {
  const [isLoading, setIsLoading] = useState(false);

  const navigate = useNavigate();
  const { register, handleSubmit, reset } = useForm<NewProductFormData>({
    resolver: zodResolver(newProductFormValidationSchema),
    defaultValues: {
      name: product?.name ?? "",
      price: product?.price ?? 0.0,
      description: product?.description ?? "",
      image: product?.image ?? "",
    },
  });

  async function handleSubmitProduct(data: NewProductFormData) {
    setIsLoading(true);

    try {
      await axios[isEditMode ? "put" : "post"](
        isEditMode && product
          ? `${import.meta.env.VITE_API_BASE_URL}/product/${product.id}`
          : `${import.meta.env.VITE_API_BASE_URL}/product`,
        data,
        {
          withCredentials: true,
        }
      );

      reset();
      setIsLoading(false);
      await successAlert(
        isEditMode
          ? "Produto atualizado com sucesso"
          : "Produto cadastrado com sucesso"
      );

      navigate("/products");
    } catch (error) {
      errorAlert(
        isEditMode ? "Erro ao atualizar produto" : "Erro ao cadastrar produto"
      );
      console.error(error);
    } finally {
      setIsLoading(false);
    }
  }

  return (
    <form
      onSubmit={handleSubmit(handleSubmitProduct)}
      className={styles.formContainer}
    >
      <div className={styles.formGroup}>
        <label htmlFor="name">Nome:</label>
        <input
          type="text"
          id="name"
          placeholder="Dígite o nome do produto"
          required
          {...register("name")}
        />
      </div>
      <div className={styles.formGroup}>
        <label htmlFor="description">Descrição:</label>
        <input
          type="text"
          id="description"
          placeholder="Digíte a descrição do produto"
          {...register("description")}
        />
      </div>
      <div className={styles.priceAndUrlImageContainer}>
        <div className={styles.formGroup}>
          <label htmlFor="price">Preço:</label>
          <input
            type="text"
            id="price"
            placeholder="Defina o preço do produto"
            required
            {...register("price", { valueAsNumber: true })}
          />
        </div>
        <div className={styles.formGroup}>
          <label htmlFor="image">URL imagem:</label>
          <input
            type="url"
            id="image"
            placeholder="URL da imagem do produto"
            required
            {...register("image")}
          />
        </div>
      </div>
      <div className={styles.actionButtonsContainer}>
        <NavLink to={"/products"}>Cancelar</NavLink>
        <button type="submit">
          Salvar
          {isLoading && <LoadingSpinner />}
        </button>
      </div>
    </form>
  );
}
