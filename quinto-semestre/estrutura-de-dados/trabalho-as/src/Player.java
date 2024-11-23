import java.util.ArrayList;
import java.util.UUID;

public class Player {
    private String name;
    private double bankBalance = 0.0;
    private Space positionOnBoard = new Start();
    private ArrayList<Property> properties = new ArrayList<Property>();

    public Player(String name) {
        this.name = name;
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

    public Space getPositionOnBoard() {
        return this.positionOnBoard;
    }

    public void setPositionOnBoard(Space positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
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
}
