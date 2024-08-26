public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("2 Implementação da Classe Matriz para Operações Matemáticas\n");

        int[][] integers = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 1 } };

        Matriz matriz = new Matriz(integers);

        // Ex: 01
        System.out.println(String.format("Ex 01: The biggest number is: %d\n", matriz.graterThan()));

        // Ex: 02
        System.out.println(String.format("Ex 02: The lowest number is: %d\n", matriz.lowerThan()));

        // Ex: 03
        System.out.println(String.format("Ex 03: The average is: %.2f\n", matriz.average()));

        // Ex: 04
        System.out.println("Ex 04: Sums by line:");
        int[] sums = matriz.sumByLine();
        for (int sum : sums) {
            System.out.println("R: " + sum);
        }
        System.out.println("\n");

        // Ex: 05
        System.out.println("Ex 05: sums by column");
        int[] sumsByColumn = matriz.sumByColumn();
        for (int sum : sumsByColumn) {
            System.out.println("R: " + sum);
        }
        System.out.println("\n");

        // Ex: 06
        System.out.println(String.format("Ex 06: The total sum is: %d\n", matriz.total()));

        // Ex: 07
        System.out.println(
                String.format("Ex 07: The total ocurrences of value %d is: %d", 1, matriz.totalOccurrencesOf(1)));
    }
}
