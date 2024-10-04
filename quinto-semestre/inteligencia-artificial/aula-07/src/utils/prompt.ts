import { input, select } from "@inquirer/prompts";
import { Response } from "../models/response";

export class Prompt {
    async ask(message: string): Promise<string> {
        const answer = await input({ message });
        return answer;
    }

    async select(question: string, responses: Response[]): Promise<Response | undefined> {
        const options = responses.map(response => response.value);

        const answer = await select<string>({
            message: `${question} >`,
            choices: [...options]
        })

        return responses.find(response => response.value === answer);
    }
}