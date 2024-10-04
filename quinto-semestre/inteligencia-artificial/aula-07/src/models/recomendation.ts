type RecomendationParams = {
    title: string;
    author: string;
}

export class Recomendation {
    readonly title: string;
    readonly author: string

    constructor({
        title,
        author
    }: RecomendationParams) {
        this.title = title;
        this.author = author;
    }
}