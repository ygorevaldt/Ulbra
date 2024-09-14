import { LocalDatabase } from "./database/local-database";
import { getPossibleAnswers } from "./utils/get-responses";
import { Prompt } from "./utils/prompt";

async function main() {
    const prompt = new Prompt();

    const database = new LocalDatabase();

    const questions = database.getQuestions();
    const responses = getPossibleAnswers(questions);

    console.log("=-=-=-=-=-= ADIVINHATOR =-=-=-=-=-= \n")
    console.log("Por favor, pense em uma das opções abaixo para eu tentar adivinhar\n");

    let possibleAnswers = "";
    let count = 1;
    responses.forEach((response) => {
        responses.length === count
            ? possibleAnswers += `${response}`
            : possibleAnswers += `${response}, `;

        count++;
    });

    console.log(`${possibleAnswers}\n`);

    for (const { title, response } of questions) {
        const answer = await prompt.select(title, [
            "Sim",
            "Não"
        ]);

        // continuar aqui, de forma recursiva

        console.log("");
    }
}

main();

