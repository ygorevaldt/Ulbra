public class Prova {
    private double gradePartOne;
    private double gradePartTwo;

    public Prova(double gradePartOne, double gradePartTwo) {
        this.gradePartOne = gradePartOne;
        this.gradePartTwo = gradePartTwo;
    }

    public double getTestGrade() {
        return gradePartOne + gradePartTwo;
    }
}
