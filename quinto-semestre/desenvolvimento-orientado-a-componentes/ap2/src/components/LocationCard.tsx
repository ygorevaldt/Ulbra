import { Location } from "../types";

export type LocationCardProps = {
    data: Location;
}

export function LocationCard({
    data
}: LocationCardProps) {
    return (
        <ul className={"p-2 flex flex-col items-center w-full"}>
            <li className="flex gap-2">
                <span className="font-black">Cidade:</span>
                <span>{data.localidade}</span>
            </li>
            <li className="flex gap-2">
                <span className="font-black">Bairro:</span>
                <span>{data.bairro}</span>
            </li>
            <li className="flex gap-2">
                <span className="font-black">CEP:</span>
                <span>{data.cep}</span>
            </li>
        </ul>
    );
}