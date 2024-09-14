import { Question } from "../models/question";
import { Response } from "../models/response";

export const questions: Question[] = [
    new Question("É homem?", new Response(
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