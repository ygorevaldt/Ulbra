import IUseCase from "@/rules/shared/IUseCase";
import Student from "../model/Student";

export default class ShowInformations implements IUseCase<Student, string> {
    execute(student: Student): string {
        return student.informations;
    }

}