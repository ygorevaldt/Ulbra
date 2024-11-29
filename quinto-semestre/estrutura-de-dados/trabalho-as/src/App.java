import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.management.relation.RoleResult;

public class App {
    public static void main(String[] args) throws Exception {
        final int MAX_PLAYERS_AMOUNT = 3;
        final double PLAYERS_INITIAL_BANK_BALANCE = 150000;
        final double PLAYERS_SALARY = 50000;
        final int MAX_ROUNDS = 10;

        Dice dice = new Dice();

        System.out.println("=-=-=-=-=-= BANCO IMOBILIÁRIO NO TERMINAL =-=-=-=-=-=");
        CircularLinkedList<ISpace> board = buildBoard();
        CircularLinkedList<Player> players = definePlayers(board.getStart(), PLAYERS_SALARY, MAX_PLAYERS_AMOUNT);

        addBalanceToPlayers(players, PLAYERS_INITIAL_BANK_BALANCE);

        int roundsAmount = 0;
        do {
            Node<Player> currentPlayerNode = players.getStart();
            boolean[] passedStart = new boolean[MAX_PLAYERS_AMOUNT];

            do {
                Player player = currentPlayerNode.getData();
                System.out.println("\nVez do jogador " + player.getName());

                int rollResult = dice.roll();
                System.out.println("\nRESULTADO DO DADO: " + rollResult);

                Node<ISpace> currentPosition = player.getPositionOnBoard();
                for (int i = 0; i < rollResult; i++) {
                    currentPosition = currentPosition.getNext();

                    if (currentPosition.getData() instanceof Start) {
                        currentPosition.getData().action(player);

                        int playerIndex = 0;
                        Node<Player> temp = players.getStart();
                        while (temp != currentPlayerNode) {
                            playerIndex++;
                            temp = temp.getNext();
                        }
                        passedStart[playerIndex] = true;
                    }
                }
                player.setPositionOnBoard(currentPosition);

                System.out.println("VOCÊ CAIU EM UMA CASA DO TIPO: " + currentPosition.getData().getDescription());

                currentPosition.getData().action(player);

                currentPlayerNode = currentPlayerNode.getNext();
            } while (currentPlayerNode != players.getStart());

            boolean allPassed = true;
            for (boolean passed : passedStart) {
                if (!passed) {
                    allPassed = false;
                    break;
                }
            }

            if (allPassed) {
                roundsAmount++;
            }
        } while (roundsAmount != MAX_ROUNDS);
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

        ArrayList<ISpace> allBoardSpaces = new ArrayList<ISpace>();
        allBoardSpaces.addAll(properties);
        allBoardSpaces.addAll(taxes);
        allBoardSpaces.addAll(restitutions);

        Collections.shuffle(allBoardSpaces);

        CircularLinkedList<ISpace> board = new CircularLinkedList<ISpace>();
        Start start = new Start();

        board.insertAtStart(start);
        for (ISpace space : allBoardSpaces) {
            board.insertAtEnd(space);
        }

        listProperties(properties);

        return board;
    }

    public static void listProperties(ArrayList<Property> properties) {
        System.out.println("\nPROPRIEDADES DISPONÍVEIS NO JOGO:");
        for (Property property : properties) {
            System.out.println(property.getName());
        }
    }

    public static CircularLinkedList<Player> definePlayers(Node<ISpace> boardStart, double salary, int playersAmount) {
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        CircularLinkedList<Player> players = new CircularLinkedList<Player>();

        for (int i = 0; i < playersAmount; i++) {
            System.out.println(String.format("Nome do %dº jogador: ", i + 1));
            String playerName = scanner.nextLine();

            if (i == 0)
                players.insertAtStart(new Player(playerName, boardStart, salary));
            else {
                players.insertAtEnd(new Player(playerName, boardStart, salary));
            }
        }

        listPlayers(players);

        return players;
    }

    public static void listPlayers(CircularLinkedList<Player> players) {
        System.out.println("\nJOGADORES DO JOGO:");

        Node<Player> current = players.getStart();

        do {
            System.out.println(current.getData().getName());
            current = current.getNext();
        } while (current != players.getStart());
    }

    public static void addBalanceToPlayers(CircularLinkedList<Player> players, double initialBalance) {
        Node<Player> current = players.getStart();

        do {
            current.getData().setBankBalance(initialBalance);
            current = current.getNext();
        } while (current != players.getStart());
    }
}
