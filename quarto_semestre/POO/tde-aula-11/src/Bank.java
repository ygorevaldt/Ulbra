import java.util.ArrayList;

public class Bank implements ICrud<Account>{
    private ArrayList<Account> accounts = new ArrayList<Account>(10);

    @Override
    public void create(Account account) {
        int numberAccount = accounts.size() + 1;
        account.setNumber(numberAccount);
        accounts.add(account);
        System.out.println("Conta criada com sucesso.");
    }

    @Override
    public Account read(int number) {
        if (accounts.size() == 0) {
            return null;
        }

        Account account = accounts.get(number - 1);

        if (account == null) {
            System.out.println("Conta não encontrada.");
            return null;
        }
        return account;

    }

    @Override
    public void update(int number, Account account) {
        Account serachAccount = this.read(number);

        if (serachAccount == null) {
            return;
        }

        accounts.set((number - 1), account);
        System.out.println("Conta atualizada.");
    }

    @Override
    public void delete(int number) {
        Account serachAccount = this.read(number);

        if (serachAccount == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        accounts.remove(number - 1);
        System.out.println("Conta deletada.");
    }
}
