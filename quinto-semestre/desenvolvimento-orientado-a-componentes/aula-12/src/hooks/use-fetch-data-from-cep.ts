import { useState, useEffect } from "react";
import { Location } from "../types/location";

export function useFetchDataFromCep(cep: string) {
    const [data, setData] = useState<Location | null>(null);

    useEffect(() => {
        if (cep.length !== 8) return;
        fetch(`https://viacep.com.br/ws/${cep}/json/`)
            .then((res) => res.json())
            .then((data) => {
                setData(data);
            })
            .catch((error) => console.log(error));
    }, [cep]);

    return [data];
}
