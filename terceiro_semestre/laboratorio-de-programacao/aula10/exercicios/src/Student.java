/*
    Exercício 1:
    Criar uma classe "Estudante" com os atributos "nome", "matricula" e "curso".
    Definir construtores para a classe:
    Construtor que recebe todos os atributos como parâmetros.
    Construtor que recebe apenas "nome" e "matricula" e define um valor padrão para "curso".
    Criar objetos do tipo "Estudante" utilizando os construtores definidos. 
*/

public class Student {
    private String Name;
    private int Registration;
    private String Course;

    public Student(String name, int registration, String course) {
        this.Name = name;
        this.Registration = registration;
        this.Course = course;
    }

    public Student(String name, int registration) {
        this.Name = name;
        this.Registration = registration;
        this.Course = "Analise e desenvolvimento de sistemas";
    }

}