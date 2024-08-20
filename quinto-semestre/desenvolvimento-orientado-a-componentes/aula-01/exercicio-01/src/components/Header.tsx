import styles from "./Header.module.css";

export function Header() {
    return (
        <header className={styles.header}>
            <h1>
                Exercício 01
            </h1>
            <p>
                Somar dois números e exibir o resultado
            </p>
        </header>
    );
}