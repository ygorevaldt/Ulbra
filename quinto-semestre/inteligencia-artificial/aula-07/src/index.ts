import { LocalDatabase } from "./database/local-database";
import { askQuestion } from "./utils/ask-question";
import { Prompt } from "./utils/prompt";
import { Response } from "./models/response";

async function main() {
    const prompt = new Prompt();
    const database = new LocalDatabase();

    const questions = database.getQuestions();
    const firstQuestion = questions[0];

    console.log("=-=-=-=-=-= Especialista em Recomendar Livros =-=-=-=-=-= \n")

    const recomendation = await askQuestion(prompt, firstQuestion, questions);
    if (!recomendation) {
        console.log("Desculpe, não consegui encontrar nenhuma boa recomendação para você");
        return;
    }

    console.log(`Minha recomendação: ${recomendation.title} de ${recomendation.author}`);
}

main();

