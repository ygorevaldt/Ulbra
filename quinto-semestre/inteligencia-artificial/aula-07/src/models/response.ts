import { Recomendation } from "./recomendation";

type ResponseParams = {
    value: string;
    redirectToQuestion?: number;
    recomendation?: Recomendation;
}

export class Response {
    readonly value: string;
    readonly redirectToQuestion?: number
    readonly recomendation?: Recomendation;

    constructor({
        value,
        redirectToQuestion,
        recomendation
    }: ResponseParams) {
        this.value = value;
        this.redirectToQuestion = redirectToQuestion;
        this.recomendation = recomendation;
    }
}
