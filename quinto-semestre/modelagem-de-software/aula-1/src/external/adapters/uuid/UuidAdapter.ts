import IUuid from "@/rules/shared/ports/IUuid";
import { v4 as uuidV4, validate } from "uuid";

export default class UuidAdapter implements IUuid {
    generateV4(): string {
        return uuidV4();
    }
    validade(value: string): boolean {
        return validate(value);
    }
}