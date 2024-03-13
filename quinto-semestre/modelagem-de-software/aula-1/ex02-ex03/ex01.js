/*
Atividade 1: Modelagem de Livros

Considere o seguinte cenário:
Suponha que você está desenvolvendo um sistema de gerenciamento escolar e precisa modelar a entidade Aluno. Crie uma classe chamada Aluno na linguagem que preferir com os seguintes atributos: nome, matricula, idade e curso. Adicione um método chamado mostrarInformacoes que retorna uma string com todas as informações do aluno. Em seguida, crie uma instância dessa classe e utilize o método mostrarInformacoes para exibir os detalhes do aluno.
*/

class Student {
    #name;
    #registration;
    #age;
    #course;

    constructor({
        name,
        registration,
        age,
        course
    } = {}) {
        this.#name = name;
        this.#registration = registration;
        this.#age = age;
        this.#course = course;
    }

    get informations() {
        return `Nome: ${this.#name} - Matrícula: ${this.#registration} - Idade: ${this.#age} - Curso: ${this.#course}`;
    }
}


const student = new Student({
    name: "Alessandra",
    registration: "40028922",
    age: 20,
    course: "ADS"
});

console.log("Informações do estudante: ", student.informations);

