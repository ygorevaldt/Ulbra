import { LocalDatabase } from "./database/local-database";
import { askQuestion } from "./utils/ask-question";
import { Prompt } from "./utils/prompt";
import { Response } from "./models/response";

async function main() {
    const prompt = new Prompt();
    const database = new LocalDatabase();

    const questions = database.getQuestions();

    console.log("=-=-=-=-=-= Especialista em Recomendar Livros =-=-=-=-=-= \n")

    let answer: Response | undefined;
    for (const question of questions) {
        answer = await askQuestion(prompt, question);
        const { redirectToQuestion, recomendation } = answer;

        // CONTINUAR DAQUI
        if (recomendation) {
            const { title, author } = recomendation;
            console.log(`Minha recomendação: ${title} de ${author}`);
            break;
        }
    }

    if (answer) return;
    console.log("Desculpe, não consegui adivinhar a resposta");
}

main();

