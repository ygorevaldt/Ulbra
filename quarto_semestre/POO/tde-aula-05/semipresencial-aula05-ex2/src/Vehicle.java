public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private Motor motor;

    public Vehicle(String brand, String model, int year, Motor motor) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.motor = motor;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Motor getMotor() {
        return motor;
    }
}
