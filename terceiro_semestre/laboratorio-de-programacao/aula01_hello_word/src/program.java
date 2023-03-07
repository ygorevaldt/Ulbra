import java.sql.SQLOutput;

public class program {
    public static void main(String[] args) {
        //Ex: 001:
        double[] numbers = {8.5, 7.5, 6.0};
        double[] weights = {3, 2, 5};
        //System.out.println(calcAverage(numbers, weights));

        //Ex: 002:
        //printNumbersInRange(10, 25);
        printNumbersInTwos(1, 100);
    }

    public static double calcAverage(double[] numbers, double[] weights) {
        double sumNumbers = 0;
        double sumWeights = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumNumbers += (numbers[i] * weights[i]);
            sumWeights += weights[i];
        }
        double result = sumNumbers / sumWeights;
        return result;
    }

    public static void printNumbersInRange(int init, int finish) {
        for (int i = init; i <= finish; i++) {
            System.out.println(i);
        }
    }

    public static void printNumbersInTwos(int init, int finish) {
        while(init <= finish) {
            System.out.println(init);
            init += 2;
        }
    }
}
