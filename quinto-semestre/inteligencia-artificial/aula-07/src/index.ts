import { LocalDatabase } from "./database/local-database";
import { askQuestion } from "./utils/ask-question";
import { Prompt } from "./utils/prompt";

async function main() {
    const prompt = new Prompt();
    const database = new LocalDatabase();

    const questions = database.getQuestions();

    console.log("=-=-=-=-=-= Especialista em Recomendar Livros =-=-=-=-=-= \n")

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

