public class Employee {
    private String Name;
    private String Function;
    private double Salary;

    public Employee(String name, String function, double salary) {
        this.Name = name;
        this.Function = function;
        this.Salary = salary;
    }

    public String getName() {
        return this.Name;
    }

    public String getFunction() {
        return this.Function;
    }

    public double getSalary() {
        return this.Salary;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setFunction(String function) {
        this.Function = function;
    }

    public void setSalary(double salary) {
        this.Salary = salary;
    }
}

class Veterinarian extends Employee {
    private String Specialty;

    public Veterinarian(String name, String function, double salary, String specialty) {
        super(name, function, salary);
        this.Specialty = specialty;
    }

    public String getSpecialty() {
        return this.Specialty;
    }

    public void setSpecialty(String specialty) {
        this.Specialty = specialty;
    }

    public void takeExam(Animal someAnimal) {
        System.out.println("O veterinário está realizando o exame em " + someAnimal.getName());
    }
}