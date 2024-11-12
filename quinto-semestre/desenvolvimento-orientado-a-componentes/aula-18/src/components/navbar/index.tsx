import { Link } from "react-router-dom";
import styles from "./styles.module.css";
import { Logo } from "../logo";

export function NavBar() {
  return (
    <aside className={styles.asideContainer}>
      <Logo />
      <ul className={styles.ulContainer}>
        <li>
          <Link to={`/`}>Início</Link>
        </li>
        <li>
          <Link to={`/about`}>Sobre</Link>
        </li>
        <li>
          <Link to={`/contact`}>Contato</Link>
        </li>
      </ul>
    </aside>
  );
}
