import java.util.ArrayList;
import java.util.UUID;

public class Player {
    private String name;
    private double bankBalance = 0.0;
    private double salary = 0.0;
    private Node<ISpace> positionOnBoard;
    private ArrayList<Property> properties = new ArrayList<Property>();
    private boolean eliminated = false;

    public Player(String name, Node<ISpace> boardStart, double salary) {
        this.name = name;
        this.positionOnBoard = boardStart;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBankBalance() {
        return this.bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public double getSalary() {
        return this.salary;
    }

    public Node<ISpace> getPositionOnBoard() {
        return this.positionOnBoard;
    }

    public void setPositionOnBoard(Node<ISpace> positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    public boolean isEliminated() {
        return this.eliminated;
    }

    public void eliminate() {
        this.eliminated = true;
    }

    public ArrayList<Property> getProperties() {
        return this.properties;
    }

    public void addProperty(Property property) {
        this.properties.add(property);
    }

    public Property getProperty(UUID id) {
        Property myProperty = null;

        for (Property property : this.properties) {
            if (property.getId() != id)
                continue;
            myProperty = property;
            break;
        }

        return myProperty;
    }

    public double getTotalPropertyValues() {
        double totalValue = 0;
        for (Property property : this.properties) {
            totalValue += property.getPrice();
        }
        return totalValue;
    }
}
