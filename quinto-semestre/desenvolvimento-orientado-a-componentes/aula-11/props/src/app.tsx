import { scientists } from "./data/scientists";
import { Gallery } from "./components/Gallery";

export function App() {
    return (
        <div className="
            flex flex-col gap-4
            p-6
        ">
            <header>
                <h1 className="font-bold text-4xl">
                    Ciêntistas notáveis
                </h1>
            </header>
            <main>
                <Gallery scientists={scientists} />
            </main>
        </div>
    );
}