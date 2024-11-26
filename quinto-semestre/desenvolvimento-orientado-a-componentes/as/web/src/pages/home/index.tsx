import { Page } from "../../components/page";

export function Home() {
  return (
    <Page>
      <header>
        <h1>Controle de Produtos</h1>
      </header>
      <main>
        <p>Bem vindo ao painel administrativo de controle de produtos.</p>
        <p>
          Acesse a página <strong>produtos</strong> para cadastrar e gerênciar
          seus produtos.
        </p>
      </main>
    </Page>
  );
}
