import { Participant } from "../types";

export function SortParticipantsAlphabetically(a: Participant, b: Participant) {
    if (a.name < b.name) {
        return -1;
    }
    if (a.name > b.name) {
        return 1;
    }
    return 0;
}