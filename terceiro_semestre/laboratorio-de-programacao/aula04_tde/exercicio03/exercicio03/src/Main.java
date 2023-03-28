public class Main {
    public static void main(String[] args) {
        Triangulo triangle = new Triangulo(1.2, 5.1);
        System.out.println(triangle.calculateArea());

        Quadrado square = new Quadrado(4);
        System.out.println(square.calculateArea());

        Circunferencia circumference = new Circunferencia(2);
        System.out.println(circumference.calculateArea());

        Trapezio trapeze = new Trapezio(10, 5, 8);
        System.out.println(trapeze.calculateArea());
    }
}