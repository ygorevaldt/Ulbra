public class Main {
    public static void main(String[] args) {
        Vehicle fox = new Vehicle("Volkswagen","Fox", 2013, new Motor(1.0));
        fox.getMotor().power();
    }
}