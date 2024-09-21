import { Response } from "./response";

type QuestionParams = {
    title: string;
    response: Response;
}

export class Question {
    readonly title: string;
    readonly response: Response;

    constructor({ title, response }: QuestionParams) {
        this.title = title;
        this.response = response;
    }
}