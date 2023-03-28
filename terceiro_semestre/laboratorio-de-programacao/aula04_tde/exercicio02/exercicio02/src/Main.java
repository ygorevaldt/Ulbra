public class Main {
    public static void main(String[] args) {
        Fracao f1 = new Fracao(2, 3);
        Fracao f2 = new Fracao(3, 4);

        Fracao result = f1.multiply(f2);

        System.out.println(result);

    }
}