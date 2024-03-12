import CourseProps from "@/rules/course/model/CourseProps";
import Entity from "@/rules/shared/entity";
import Duration from "@/rules/shared/value-objects/Duration";
import Name from "@/rules/shared/value-objects/Name";

export default class Course extends Entity {
    readonly name: Name;
    readonly duration: Duration

    constructor({
        id,
        name,
        duration
    }: CourseProps) {
        super(id!);
        this.name = new Name(name);
        this.duration = new Duration(duration);
    }
}