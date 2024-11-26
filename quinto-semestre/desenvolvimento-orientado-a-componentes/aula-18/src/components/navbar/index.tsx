import { NavLink } from "react-router-dom";
import styles from "./styles.module.css";
import { Logo } from "../logo";

export function NavBar() {
  return (
    <aside className={styles.asideContainer}>
      <Logo />
      <ul className={styles.ulContainer}>
        <li>
          <NavLink to={`/`}>Início</NavLink>
        </li>
        <li>
          <NavLink to={`/about`}>Sobre</NavLink>
        </li>
        <li>
          <NavLink to={`/contact`}>Contato</NavLink>
        </li>
      </ul>
    </aside>
  );
}
