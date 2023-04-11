public class App {
    public static void main(String[] args) throws Exception {
        Student student01 = new Student();
        student01.setName("Lucas");
        student01.setAge(28);
        student01.setPoints(500);

        Student student02 = new Student();
        student02.setName("Ygor");
        student02.setAge(26);
        student02.setPoints(1000);

        Student student03 = new Student();
        student03.setName("Alessandra");
        student03.setAge(20);
        student03.setPoints(900);

        Gymkhana gymkhana = new Gymkhana();
        gymkhana.setGymkhanaName("Queimado");
        gymkhana.setWinningStudent(student01);

        gymkhana.addStudent(student01);
        gymkhana.addStudent(student02);
        gymkhana.addStudent(student03);

        System.out.println("Total de participantes da gincana: " + gymkhana.getTotalStudents());
        gymkhana.showWinner();

    }
}
