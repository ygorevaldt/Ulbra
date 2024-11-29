public class Start implements ISpace {
    @Override
    public void action(Player player) {
        double newPlayerBankBalance = player.getBankBalance() + player.getSalary();

        player.setBankBalance(newPlayerBankBalance);
        System.out.println(String.format("%s RECEBEU %.2f DE SALARIO", player.getName(), player.getSalary()));
        System.out.println(String.format("SALDO BANCARIO ATUAL: %.2f", player.getBankBalance()));
    }

    @Override
    public String getDescription() {
        return "Início";
    }
}
