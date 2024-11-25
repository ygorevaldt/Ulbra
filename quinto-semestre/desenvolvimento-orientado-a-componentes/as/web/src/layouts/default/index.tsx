import { Outlet } from "react-router";
import styles from "./styles.module.css";
import { NavBar } from "../../components/navbar";

export function Default() {
  return (
    <div className={styles.pageContainer}>
      <NavBar />
      <div className={styles.outletContainer}>
        <Outlet />
      </div>
    </div>
  );
}
