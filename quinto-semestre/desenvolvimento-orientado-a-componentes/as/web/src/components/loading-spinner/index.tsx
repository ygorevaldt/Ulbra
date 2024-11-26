import styles from "./styles.module.css";

type LoadingSpinnerProps = {
  className?: "red" | "green" | "gray" | "black";
};

export function LoadingSpinner({ className }: LoadingSpinnerProps) {
  return (
    <span className={`${styles.spinner} ${styles[className ?? ""]}`}></span>
  );
}
