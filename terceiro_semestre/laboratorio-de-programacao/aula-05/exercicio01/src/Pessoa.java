/*
    Crie uma classe chamada "Pessoa" que representará uma pessoa. Esta classe deve ter:
    Três atributos privados: "nome" (String), "idade" (int) e "altura" (double).
    Métodos públicos para obter (get) e definir (set) os valores dos atributos.
*/
public class Pessoa {
    private String name;
    private int age;
    private double heigth;

    public Pessoa(String name, int age, double heigth) {
        this.name = name;
        this.age = age;
        this.heigth = heigth;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getHeigth() {
        return this.heigth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

}

