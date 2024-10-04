import { type } from "os";
import { Question } from "../models/question";
import { Prompt } from "./prompt";

export async function askQuestion(prompt: Prompt, question: Question) {
    const answer = (await prompt
        .select(
            question.title,
            question.responses
        ));

    return answer;
}