import { useNavigate } from "react-router-dom";
import { z as zod } from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import axios from "axios";

import styles from "./styles.module.css";

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

export function ProductForm() {
  const navigate = useNavigate();
  const { register, handleSubmit, reset } = useForm<NewProductFormData>({
    resolver: zodResolver(newProductFormValidationSchema),
    defaultValues: {
      name: "",
      price: 0.0,
      description: "",
    },
  });

  async function handleSubmitProduct(data: NewProductFormData) {
    console.log("data", data);
    try {
      await axios.post("http://localhost:3333/product", data, {
        withCredentials: true,
      });
      alert("Produto cadastrado com sucesso");
      reset();
      navigate("/products");
    } catch (error) {
      alert("Erro ao cadastrar produto");
      console.error(error);
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
      <div className={styles.submitButton}>
        <button type="submit">Salvar</button>
      </div>
    </form>
  );
}
