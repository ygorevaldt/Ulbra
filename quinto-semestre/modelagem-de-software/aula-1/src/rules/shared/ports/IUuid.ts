export default interface IUuid {
    generateV4(): string;
    validade(value: string): boolean
}