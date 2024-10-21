import { Location } from "../types/location";

type LocationCardProps = {
    data: Location;
}

export function LocationCard({
    data
}: LocationCardProps) {
    if (!data) return <></>;

    return (
        <ul className="text-white">
            <li className="flex gap-2">
                <span className="font-black">Estado:</span>
                <p className="text-zinc-300">{data.estado} - {data.uf}</p>
            </li>
            <li className="flex gap-2">
                <span className="font-black">Localidade:</span>
                <p className="text-zinc-300">{data.localidade}</p>
            </li>
            <li className="flex gap-2">
                <span className="font-black">Região:</span>
                <p className="text-zinc-300">{data.regiao}</p>
            </li>
            <li className="flex gap-2">
                <span className="font-black">Cep:</span>
                <p className="text-zinc-300">{data.cep}</p>
            </li>
        </ul>
    );
}
