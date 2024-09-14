import { Question } from "../types/question";
import { Response } from "../types/response";

export const questions: Question[] = [
    new Question("É homen?", new Response(
        new Question("Ele joga futebol?", new Response(
            new Question("Ele é goleiro?", new Response("Julio Cezar", "Neymar"))
        ))
    )),
    new Question("É mulher?", new Response(
        new Question("Ela é famosa?", new Response(
            new Question("Ele é modelo?", new Response("Gisele Bündchen", "Margot Robbie"))
        ))
    ))
]