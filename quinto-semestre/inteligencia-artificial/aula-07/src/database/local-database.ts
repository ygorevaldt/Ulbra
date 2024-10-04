import { questions } from "./data";

export class LocalDatabase {
    private db = { questions }

    getQuestions() {
        return this.db.questions;
    }
}