import { Question } from "./question";

export class Response {
    constructor(
        readonly yes: string | Question,
        readonly no?: string
    ) { }
}