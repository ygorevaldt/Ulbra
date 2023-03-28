public class Aluno {
    private Prova test01;
    private Prova test02;

    private double avarege;

    public Aluno(Prova test01, Prova test02) {
        this.test01 = test01;
        this.test02 = test02;
    }

    public double getAvarege() {
        double noteTest01 = this.test01.getTestGrade();
        double noteTest02 = this.test02.getTestGrade();
        int qntTests = 2;

        return (noteTest01 + noteTest02) / qntTests;
    }
}
