import { useEffect, SetStateAction } from "react";
import { Participant } from "../types";

export function useStoredParticipants(callback: (value: SetStateAction<Participant[]>) => void) {
    useEffect(() => {
        const storedParticipants = localStorage.getItem("participants");
        if (!storedParticipants) return;

        callback(JSON.parse(storedParticipants));
    }, []);
}