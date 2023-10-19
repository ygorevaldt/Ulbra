public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account account = new Account();

        bank.create(account);

        account.setBalance(1000);
        bank.update(1, account);

        System.out.println(bank.read(1));

        bank.delete(1);
        bank.delete(3);
    }
}