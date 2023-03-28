import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");

        Prova test01 = new Prova(4.0, 2.5);
        Prova test02 = new Prova(1.0, 7.0);
        Prova test03 = new Prova(6.5, 3.5);
        Prova test04 = new Prova(0.0, 3.0);
        Prova test05 = new Prova(5.0, 4.0);
        Prova test06 = new Prova(6.0, 1.5);

        Aluno student01 = new Aluno(test01, test02);
        Aluno student02 = new Aluno(test03, test04);
        Aluno student03 = new Aluno(test05, test06);

        Turma studentsClass = new Turma(student01, student02, student03);
        double classAvarege = studentsClass.getAvarege();

        System.out.println("Média do aluno 01: " + student01.getAvarege());
        System.out.println("Média do aluno 02: " + student02.getAvarege());
        System.out.println("Média do aluno 03: " + student03.getAvarege());

        System.out.println("Média da turma: " + df.format(classAvarege));
    }

}