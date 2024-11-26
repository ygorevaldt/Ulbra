import { ProductForm } from "../../components/product-form";
import { Page } from "../../components/page";

import styles from "./styles.module.css";
import contactSvg from "../../assets/contact-svg.svg";

export function Contact() {
  return (
    <Page>
      <header>
        <h1>Página Contato</h1>
      </header>
      <main className={styles.mainContainer}>
        <ProductForm />
        <img
          className={styles.svg}
          src={contactSvg}
          alt="Ilustração de contato"
        />
      </main>
    </Page>
  );
}
