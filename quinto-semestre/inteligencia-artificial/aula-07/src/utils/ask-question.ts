import { type } from "os";
import { Question } from "../models/question";
import { Prompt } from "./prompt";

export async function askQuestion(prompt: Prompt, question: Question) {
    const answer = (await prompt
        .select(
            question.title,
            question.responses
        ));

    console.log(answer);
    return;

    if (answer === "não") {
        if (!question.response.no) return;

        if (question.response.no instanceof Question) {
            return await askQuestion(prompt, question.response.no);
        }

        return question.response.no;
    }

    if (question.response.yes instanceof Question) {
        return await askQuestion(prompt, question.response.yes);
    }

    return question.response.yes
}