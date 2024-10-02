import { Scientist } from "../types";

type ProfileProps = {
    scientist: Scientist;
}

export function Profile({
    scientist
}: ProfileProps) {
    return (
        <article className="profile-card">
            <header>
                <h2 className="
                    text-2xl font-black
                ">
                    {scientist.name}
                </h2>
            </header>
            <img
                className="w-20 h-20 rounded-full"
                src={scientist.imgPath}
                alt={`Retrato do cientista ${scientist.name}`}
            />
            <ul>
                <li key={0} className="flex gap-1">
                    <span className="font-bold">Profissão:</span>
                    <p>{scientist.profession}</p>
                </li>
                <li key={1} className="flex gap-1">
                    <p className="flex gap-1">
                        <span className="font-bold">Prêmios:</span>
                        <strong>{scientist.awards.length}</strong>
                    </p>
                    <div>
                        {
                            scientist.awards.map((award, index) => {
                                return scientist.awards.length - 1 !== index
                                    ? <span>{award.name}, </span>
                                    : <span>{award.name}</span>
                            })
                        }
                    </div>
                </li>
                <li key={2} className="flex gap-1">
                    <span className="font-bold">Descoberta</span>
                    <p>{scientist.discovered}</p>
                </li>
            </ul>
        </article>
    );
}