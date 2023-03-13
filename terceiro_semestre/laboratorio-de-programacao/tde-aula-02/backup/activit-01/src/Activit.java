public class Activit {
    public static void main(String[] args) {
        //Ex: 001:
        double[] numbers = {8.5, 7.5, 6.0};
        double[] weights = {3, 2, 5};
        System.out.println(calcAverage(numbers, weights));
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
}
