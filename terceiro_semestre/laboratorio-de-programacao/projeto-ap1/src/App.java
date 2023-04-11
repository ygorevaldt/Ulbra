public class App {
    public static void main(String[] args) throws Exception {
        Student student01 = new Student();
        student01.setName("Lucas");
        student01.setAge(28);
        student01.setPoints(100);

        Gymkhana gymkhana = new Gymkhana();
        gymkhana.setGymkhanaName("Queimado");
        gymkhana.setWinningStudent(student01);

        System.out.println(gymkhana.getWinningStudent().getName());
        System.out.println(gymkhana.getMaxPoints());

    }
}
