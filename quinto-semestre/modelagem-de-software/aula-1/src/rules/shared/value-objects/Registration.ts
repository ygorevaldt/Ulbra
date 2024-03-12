export default class Registration {
    constructor(
        readonly value: number,
    ) {
        if (this.value <= 0) throw new Error("Matrícula inválida");
    }
}