import { Response } from "./response";

export class Question {
    constructor(
        readonly title: string,
        readonly response: Response
    ) { }
}