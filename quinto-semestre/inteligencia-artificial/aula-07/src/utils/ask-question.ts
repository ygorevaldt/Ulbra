import { Question } from "../models/question";
import { Prompt } from "./prompt";

export async function askQuestion(prompt: Prompt, question: Question, questions: Question[]) {
    const answer = (await prompt
        .select(
            question.title,
            question.responses
        ));

    const askAgain = answer.redirectToQuestion && !answer.recomendation
    if (askAgain) {
        const question = questions.find(question => question.id === answer.redirectToQuestion);
        return await askQuestion(prompt, question!, questions);
    }

    return answer.recomendation;
}
