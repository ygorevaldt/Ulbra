import { scientists } from "./data/scientists";
import './App.css'
import { Gallery } from "./components/gallery";

export function App() {
    return (
        <>
            <header>
                <h1>
                    Ciêntistas notáveis
                </h1>
            </header>
            <main>
                <Gallery scientists={scientists} />
            </main>
        </>
    );
}