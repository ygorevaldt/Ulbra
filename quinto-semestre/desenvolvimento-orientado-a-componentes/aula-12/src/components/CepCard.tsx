import { ChangeEvent, FormEvent, useState } from "react";

type CepCardProps = {
    getCep: (event: FormEvent<HTMLFormElement>, cep: string) => void;
}

export function CepCard({
    getCep
}: CepCardProps) {
    const [cepValue, setCelValue] = useState("");

    function handleChangeCepValue(event: ChangeEvent<HTMLInputElement>) {
        setCelValue(event.target.value);
    }

    return (
        <form onSubmit={(event) => getCep(event, cepValue)} className="flex gap-2 items-center">
            <label
                className="font-bold text-white"
                htmlFor="cep"
            >
                Cep:
            </label>
            <input
                className="border-blue-600 border rounded-md px-2 py-1 text-black"
                onChange={handleChangeCepValue}
                type="text"
                id="cep"
                placeholder="Digíte o CEP"
            />
            <button
                className="px-2 py-1 bg-blue-500 text-white rounded-md"
                type="submit"
            >
                Pesquisar
            </button>
        </form>
    );
}
