import { Location } from "../types";

export type LocationCardProps = {
    data: Location;
}

export function LocationCard({
    data
}: LocationCardProps) {
    return (
        <ul>
            <li>
                <span>Cidade</span>
                <span>{data.localidade}</span>
            </li>
            <li>
                <span>Bairro</span>
                <span>{data.bairro}</span>
            </li>
            <li>
                <span>CEP</span>
                <span>{data.cep}</span>
            </li>
        </ul>
    );
}