import { useState } from "react";

import { Page } from "../components/Page";

import { useStoredParticipants } from "../hooks/use-get-stored-contacts";
import { Participant } from "../types";
import { ParticipantCard } from "../components/ParticipantCard";
import { useFetchDataFromCep } from "../hooks/use-fetch-data-from-cep";
import { LocationCard } from "../components/LocationCard";
import { SortParticipantsAlphabetically } from "../utils/sort-participants-alphabetically";

const data = {
    user: {
        name: "Professor Daniel"
    },
    cep: "95560970"
};

export function Home() {
    const [participants, setParticipants] = useState<Participant[]>([]);
    const [isShowingLocationData, setIsShowingLocationData] = useState(false);

    const [location] = useFetchDataFromCep(data.cep);

    function handleShowLocationData() {
        setIsShowingLocationData(!isShowingLocationData);
    }

    useStoredParticipants(setParticipants);

    return (
        <Page title="Entrevero">
            <main className="flex flex-col gap-4">
                <section className="flex justify-between items-start">
                    <h2 className="font-bold text-xl text-zinc-500">
                        Seja bem vindo {data.user.name}
                    </h2>
                    <div>
                        <button
                            className="btn text-xl rounded-3xl"
                            onClick={handleShowLocationData}
                        >
                            Mostrar localização
                        </button>
                        {location !== null
                            && isShowingLocationData
                            && <LocationCard data={location} />}
                    </div>
                </section>
                <section>
                    <h2 className="font-bold text-xl">Participantes</h2>
                    <ul className="
                        grid 
                        lg:grid-cols-3 gap-3
                        md:grid-cols-2
                        sm:grid-cols-1
                    ">
                        {participants
                            .sort(SortParticipantsAlphabetically)
                            .map(participant => {
                                return (<li key={participant.name}>
                                    <ParticipantCard participant={participant} />
                                </li>);
                            })}
                    </ul>
                </section>
            </main>
        </Page>
    );
}