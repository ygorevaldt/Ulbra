import { Page } from "../../components/page";
import { ProductForm } from "../../components/product-form";

export function ProductsRegister() {
  return (
    <Page>
      <header>
        <h1>Registrar Novo Produto</h1>
      </header>
      <main>
        <ProductForm />
      </main>
    </Page>
  );
}
