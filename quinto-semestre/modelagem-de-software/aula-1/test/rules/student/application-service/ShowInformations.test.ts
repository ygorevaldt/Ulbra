import Course from "@/rules/course/model/Course"
import ShowInformations from "@/rules/student/application-service/ShowInformations";
import Student from "@/rules/student/model/Student";

function factory() {
    const course = new Course({
        name: "Modelagem de software",
        duration: 160
    });
    const student = new Student({
        name: "Aluno",
        registration: 123,
        age: 27,
        course
    });
    const usecase = new ShowInformations();

    return ({
        course,
        student,
        usecase
    });
}

describe('ShowInformations', () => {
    test('should return students informations', () => {
        const { course, student, usecase } = factory();
        const informations = usecase.execute(student);
        expect(informations).toBeDefined();
    });
})