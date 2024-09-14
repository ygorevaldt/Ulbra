import { input, select } from "@inquirer/prompts";

export class Prompt {
    async ask(message: string): Promise<string> {
        const answer = await input({ message });
        return answer;
    }

    async select(question: string, options: string[]): Promise<string> {
        const answer = await select<string>({
            message: `${question} >`,
            choices: [...options]
        })
        return answer;
    }
}