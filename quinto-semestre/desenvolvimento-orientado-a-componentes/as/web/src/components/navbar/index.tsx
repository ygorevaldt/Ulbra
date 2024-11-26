import { NavLink } from "react-router-dom";
import styles from "./styles.module.css";
import { Logo } from "../logo";

export function NavBar() {
  return (
    <aside className={styles.asideContainer}>
      <NavLink to={`/`} className={`${styles.navLink} ${styles.logoContainer}`}>
        <Logo />
        Início
      </NavLink>
      <ul className={styles.ulContainer}>
        <li>
          <NavLink to={`/products`} className={styles.navLink}>
            Produtos
          </NavLink>
        </li>
      </ul>
    </aside>
  );
}
