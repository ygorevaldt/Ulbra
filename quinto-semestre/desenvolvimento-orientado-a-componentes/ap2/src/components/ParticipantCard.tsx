import { Participant } from "../types";
import { Avatar } from "./Avatar";

type ParticipantCardProps = {
    participant: Participant;
}

export function ParticipantCard({
    participant
}: ParticipantCardProps) {
    return (
        <article className="
            flex flex-col gap-2
            justify-center items-center
            rounded-md shadow-sm p-6
            bg-zinc-100 text-zinc-900 bg-opacity-50
        ">
            <Avatar imgUrl={participant.imgUrl} />
            <span className="font-black text-2xl">{participant.name}</span>
            <span>{participant.guest ? "Egresso|Convidado" : "Estudante"}</span>
            <span>{participant.paid ? "Confirmado" : "Não confirmado"}</span>
        </article>
    );
}
