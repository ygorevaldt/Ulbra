import Course from "@/rules/course/model/Course";

export default interface StudentProps {
    id?: string,
    name: string,
    registration: number,
    age: number,
    course: Course
}