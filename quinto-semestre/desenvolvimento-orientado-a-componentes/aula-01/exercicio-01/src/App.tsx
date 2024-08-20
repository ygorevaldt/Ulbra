import { useState } from "react";
import styles from "./App.module.css";
import { Header } from "./components/Header";

export function App() {
    const [value1, setValue1] = useState(0);
    const [value2, setValue2] = useState(0);

    const [result, setResult] = useState(0);

    function sum() {
        setResult(Number(value1) + Number(value2));
    }

    function clear() {
        setResult(0);
        setValue1(0);
        setValue2(0);
    }

    return (
        <>
            <Header />
            <main className={styles.main}>
                <form>
                    <div className={styles.inputBox}>
                        <div>
                            <label htmlFor="firstValue">Primeiro valor:</label>
                            <input
                                type="number"
                                name="firstValue"
                                value={value1}
                                onChange={(event) => setValue1(Number(event.target.value))}
                            />
                        </div>
                        <div>
                            <label htmlFor="secondValue">Segundo valor:</label>
                            <input
                                type="number"
                                name="secondValue"
                                value={value2}
                                onChange={(event) => setValue2(Number(event.target.value))}
                            />
                        </div>
                    </div>
                    <div className={styles.actionBox}>
                        <button
                            className={styles.clear}
                            type="button"
                            onClick={clear}
                        >
                            Zerar
                        </button>
                        <button
                            className={styles.sum}
                            type="button"
                            onClick={sum}
                        >
                            Somar
                        </button>
                    </div>
                </form>
                <footer className={styles.resultBox}>
                    <strong>Resultado:</strong>
                    <span>{result}</span>
                </footer>
            </main>
        </>
    );
}

