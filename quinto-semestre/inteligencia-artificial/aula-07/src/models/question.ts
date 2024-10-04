import { Response } from "./response";

type QuestionParams = {
    id: number;
    title: string;
    responses: Response[];
}

export class Question {
    readonly id: number;
    readonly title: string;
    readonly responses: Response[];

    constructor({ id, title, responses }: QuestionParams) {
        this.id = id;
        this.title = title;
        this.responses = responses;
    }
}
