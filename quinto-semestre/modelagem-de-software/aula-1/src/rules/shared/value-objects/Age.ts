export default class Age {
    constructor(
        readonly value: number
    ) {
        if (value < 0) throw new Error("Idade inválida");
        if (value > 120) throw new Error("Idade inválida");
    }
}