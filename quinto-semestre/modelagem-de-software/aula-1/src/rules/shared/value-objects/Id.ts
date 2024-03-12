import UuidAdapterInstance from "@/external/adapters/uuid/UuidAdapterInstance";

export default class Id {
    constructor(
        readonly value: string = UuidAdapterInstance.generateV4()
    ) {
        if (!UuidAdapterInstance.validade(this.value)) throw new Error("Id inválido");
    }
}