public class Turma {
    private Aluno student01;
    private Aluno student02;
    private Aluno student03;

    public Turma(Aluno student01, Aluno student02, Aluno student03) {
        this.student01 = student01;
        this.student02 = student02;
        this.student03 = student03;
    }

    public double getAvarege() {
        double note01 = this.student01.getAvarege();
        double note02 = this.student02.getAvarege();
        double note03 = this.student03.getAvarege();
        int qntNotes = 3;

        double avarege = (note01 + note02 + note03) / qntNotes;

        return avarege;
    }
}
