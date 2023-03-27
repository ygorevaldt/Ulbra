/*
    Crie uma classe chamada "ContaBancaria" que representará uma conta bancária. Esta classe deve ter:
    Três atributos privados: "numeroConta" (String), "saldo" (double) e "titular" (Pessoa).
    Métodos públicos para depositar (depositar), sacar (sacar) e consultar o saldo (getSaldo).
*/

public class ContaBancaria {
    private String account;
    private double balance;
    private Pessoa holder;

    public ContaBancaria(String account, double balance, Pessoa holder) {
        this.account = account;
        this.balance = balance;
        this.holder = holder;
    }

    public void deposit(double value) {
        if (value <= 0) {
            System.out.println("Valos inválido");
        }
        else {
            this.balance += value;
            System.out.println("Depósito realizado com sucesso." + "Saldo total: R$" + this.balance);
        }
    }

    public void withdraw(double value) {
        if (value <= 0) {
            System.out.println("Valor inválido");
        }
        else if (this.balance < value) {
            System.out.println("Saldo insuficiênte");
        }
        else {
            this.balance -= value;
            System.out.println("Retirado R$" + value + " " + "Saldo restante R$" + this.balance);
        }
    }

    public String getBalance() {
        return "Saldo R$" + this.balance;
    }
}
