import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=-=-=-=-=-= BANCO IMOBILIÁRIO NO TERMINAL =-=-=-=-=-=");

        Dice dice = new Dice();

        ArrayList<Player> players = new ArrayList<Player>(
                Arrays.asList(
                        new Player("Jogador 1"),
                        new Player("Jogador 2"),
                        new Player("Jogador 3"),
                        new Player("Jogador 4")));

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

        Start start = new Start();

        Board board = new Board<ISpace>(new Node<ISpace>(start));

        ArrayList<ISpace> allSpaces = new ArrayList<ISpace>();
        allSpaces.addAll(properties);
        allSpaces.addAll(taxes);
        allSpaces.addAll(restitutions);

        for (ISpace space : allSpaces) {
            board.insertAtEnd(new Node<ISpace>(space));
        }

        board.print();

    }
}
