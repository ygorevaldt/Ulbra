import { Question } from "../models/question";
import { Response } from "../models/response";

export function getPossibleAnswers(questions: Question[]) {
    const answers: string[] = [];

    questions.forEach((question) => {
        traverseQuestion(answers, question)
    });

    return answers;
}

function traverseQuestion(answers: string[], question: Question) {
    traverseResponse(answers, question.response);
}

function traverseResponse(answers: string[], response: Response) {
    if (typeof response.yes === 'string') {
        answers.push(response.yes);
    } else {
        traverseQuestion(answers, response.yes as Question);
    }
    if (response.no) {
        if (typeof response.no === 'string') {
            answers.push(response.no);
        } else {
            traverseQuestion(answers, response.no as Question);
        }
    }
}

