public class Start implements ISpace {
    @Override
    public void action(Player player) {
        double newPlayerBankBalance = player.getBankBalance() + player.getSalary();

        player.setBankBalance(newPlayerBankBalance);
        System.out.println(String.format("VOCÊ RECEBEU %.2f DE SALARIO", player.getSalary()));
    }

    @Override
    public String getDescription() {
        return "Início";
    }
}
