public class Activit {
    public static void main(String[] args) {
        printNumbersInTwos(1, 100);
    }
    public static void printNumbersInTwos(int init, int finish) {
        while(init <= finish) {
            System.out.println(init);
            init += 2;
        }
    }
}
