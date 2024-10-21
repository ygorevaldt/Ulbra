import { FormEvent, useState } from "react";
import { CepCard } from "./components/CepCard";
import { useFetchDataFromCep } from "./hooks/use-fetch-data-from-cep";
import { LocationCard } from "./components/LocationCard";

export function App() {
    const [cep, setCep] = useState("");

    function getCep(event: FormEvent<HTMLFormElement>, cep: string) {
        event.preventDefault();
        setCep(cep);
    }

    const [location] = useFetchDataFromCep(cep);

    return (
        <div className="
            flex flex-col gap-4
            bg-zinc-700 min-h-screen
        ">
            <header className="
                bg-zinc-900 
                text-white font-black text-2xl
                px-2 py-4
            ">
                <h1>
                    TDE - Aula 12
                </h1>
            </header>
            <main className="
                flex-grow flex flex-col gap-4
                items-center justify-center content-start
            ">
                <CepCard getCep={getCep} />
                {location && <LocationCard data={location!} />}
            </main>
            <pre>

            </pre>
        </div>
    );
}
