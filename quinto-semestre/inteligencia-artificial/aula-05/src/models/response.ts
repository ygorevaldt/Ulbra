import { Question } from "./question";

type ResponseParams = {
    yes: string | Question;
    no?: string | Question
}

export class Response {
    readonly yes: string | Question;
    readonly no?: string | Question;

    constructor({ yes, no }: ResponseParams) {
        this.yes = yes;
        this.no = no;
    }
}