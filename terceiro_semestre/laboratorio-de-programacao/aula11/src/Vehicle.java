public abstract class Vehicle {
    String Brand;
    String Model;

    public abstract void showDetails();
}

class Car extends Vehicle {
    int NumPassengers = 0;

    public Car(String brand, String model, int numPassengers) {
        this.Brand = brand;
        this.Model = model;
        this.NumPassengers = numPassengers;
    }
    public Car(String brand, String model) {
        this.Brand = brand;
        this.Model = model;
    }

    public void showDetails() {
        if (this.NumPassengers != 0) {
            System.out.println("Marca: " + this.Brand + " Modelo: " + this.Model + " número de passageiros: " + this.NumPassengers);
        } else {
            System.out.println("Marca: " + this.Brand + " Modelo: " + this.Model);
        }
    };
}
