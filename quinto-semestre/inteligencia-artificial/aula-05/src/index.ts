import { LocalDatabase } from "./database/local-database";
import { askQuestion } from "./utils/ask-question";
import { displayPossibleAnswers } from "./utils/display-possible-answers";
import { getPossibleAnswers } from "./utils/get-responses";
import { Prompt } from "./utils/prompt";

async function main() {
    const prompt = new Prompt();
    const database = new LocalDatabase();

    const questions = database.getQuestions();
    const answers = getPossibleAnswers(questions);

    console.log("=-=-=-=-=-= ADIVINHATOR =-=-=-=-=-= \n")
    console.log("Por favor, pense em uma das opções abaixo para eu tentar adivinhar\n");

    displayPossibleAnswers(answers);

    let answer: string | undefined;
    for (const question of questions) {
        answer = await askQuestion(prompt, question);
        if (!answer) continue;

        console.log(`Você pensou em: ${answer}`);
        break;
    }

    if (answer) return;
    console.log("Desculpe, não consegui adivinhar a resposta");
}

main();

