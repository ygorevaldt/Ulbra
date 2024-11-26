import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Dice dice = new Dice();
        Scanner scanner = new Scanner(System.in);

        CircularLinkedList<Player> players = definePlayers();
        CircularLinkedList<ISpace> board = buildBoard();

        System.out.println("=-=-=-=-=-= BANCO IMOBILIÁRIO NO TERMINAL =-=-=-=-=-=");

        System.out.print("Digite o saldo inicial dos jogadores: ");
        double initialBalance = scanner.nextDouble();
        addBalanceToPlayers(players, initialBalance);

        System.out.print("Digite o salário dos jogadores: ");
        double playerSalary = scanner.nextDouble();

        System.out.print("Digite o número máximo de rodadas: ");
        int maxRounds = scanner.nextInt();

    }

    public static CircularLinkedList<ISpace> buildBoard() {
        ArrayList<Property> properties = new ArrayList<Property>(
                Arrays.asList(
                        new Property("Casa do Bosque", 200000.00, 1100.00),
                        new Property("Apartamento Central", 350000.00, 1800.00),
                        new Property("Vila das Flores", 400000.00, 2200.00),
                        new Property("Pousada da Praia", 500000.00, 2700.00),
                        new Property("Mansão da Colina", 600000.00, 3300.00),
                        new Property("Residência do Lago", 450000.00, 2500.00),
                        new Property("Cobertura Diamante", 700000.00, 3700.00),
                        new Property("Edifício Horizonte", 550000.00, 2900.00),
                        new Property("Chácara do Sol", 300000.00, 1600.00),
                        new Property("Fazenda Boa Vista", 250000.00, 1300.00)));

        ArrayList<Tax> taxes = new ArrayList<Tax>(
                Arrays.asList(
                        new Tax(),
                        new Tax(),
                        new Tax(),
                        new Tax(),
                        new Tax()));

        ArrayList<Restitution> restitutions = new ArrayList<Restitution>(
                Arrays.asList(
                        new Restitution(),
                        new Restitution(),
                        new Restitution(),
                        new Restitution(),
                        new Restitution()));

        ArrayList<ISpace> allSpaces = new ArrayList<ISpace>();
        allSpaces.addAll(properties);
        allSpaces.addAll(taxes);
        allSpaces.addAll(restitutions);

        Collections.shuffle(allSpaces);

        Start start = new Start();
        CircularLinkedList<ISpace> board = new CircularLinkedList<ISpace>(new Node<ISpace>(start));

        for (ISpace space : allSpaces) {
            board.insertAtEnd(space);
        }

        return board;
    }

    public static CircularLinkedList<Player> definePlayers() {
        Player player1 = new Player("Jogador 1");
        Player player2 = new Player("Jogador 2");
        Player player3 = new Player("Jogador 3");

        CircularLinkedList<Player> players = new CircularLinkedList<Player>(new Node<Player>(player1));
        players.insertAtEnd(player2);
        players.insertAtEnd(player3);

        return players;
    }

    public static void addBalanceToPlayers(CircularLinkedList<Player> players, double initialBalance) {
        Node<Player> current = players.getStart();

        do {
            current.getData().setBankBalance(initialBalance);
            current = current.getNext();
        } while (current != players.getStart());
    }
}
