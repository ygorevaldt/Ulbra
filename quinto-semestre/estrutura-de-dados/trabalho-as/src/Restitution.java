public class Restitution implements ISpace {

    @Override
    public void action(Player player) {
        double playerSalaryPlus10percent = player.getSalary() * 10 / 100;
        player.setBankBalance(player.getBankBalance() + playerSalaryPlus10percent);

        System.out.println(String.format(
                "VOCÊ RECEBEU %.2f DE RESTITUIÇÃO FINANCEIRA",
                player.getSalary() + playerSalaryPlus10percent));
    }

    @Override
    public String getDescription() {
        return "Restituição";
    }

}
