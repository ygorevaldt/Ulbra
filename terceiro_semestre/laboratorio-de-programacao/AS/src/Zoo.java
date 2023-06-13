public class Zoo {
    private Animal[] Animals;
    private Employee[] Employees;

    public Zoo(int amountAnimals, int amountEmployees) {
        this.Animals = new Animal[amountAnimals];
        this.Employees = new Employee[amountEmployees];
    }

    public Animal[] getAnimals() {
        return this.Animals;
    }

    public Employee[] getEmployees() {
        return this.Employees;
    }

    public void setAnimals(Animal[] animals) {
        if (animals.length > this.Animals.length) {
            System.out.println("O Zoológico só pode ter " + this.Animals.length + " animais");
            return;
        }

        this.Animals = animals;
    }

    public void setEmployees(Employee[] employees) {
        if (employees.length > this.Employees.length) {
            System.out.println("O Zoológico só pode ter " + this.Employees.length + " funcionários");
            return;
        }

        this.Employees = employees;
    }
}
