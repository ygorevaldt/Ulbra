import Course from "@/rules/course/model/Course";
import Entity from "@/rules/shared/entity";
import Age from "@/rules/shared/value-objects/Age";
import Name from "@/rules/shared/value-objects/Name";
import Registration from "@/rules/shared/value-objects/Registration";
import StudentProps from "@/rules/student/model/StudentProps";

export default class Student extends Entity {
    readonly name: Name;
    readonly registration: Registration;
    readonly age: Age;
    readonly course: Course;

    constructor({
        id,
        name,
        registration,
        age,
        course
    }: StudentProps) {
        super(id!);
        this.name = new Name(name);
        this.registration = new Registration(registration);
        this.age = new Age(age);
        this.course = course;
    }

    get informations(): string {
        return `Nome: ${this.name.complete} - Matrícula: ${this.registration.value} - Idade: ${this.age.value} - Curso: ${this.course.name.complete}`;
    }
}