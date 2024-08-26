public class Matriz {
    int[][] integers;

    public Matriz(int[][] integers) {
        this.integers = integers;
    }

    /*
     * Ex 01
     * Obter Maior Elemento:
     * Implemente um método que retorne o maior valor presente na matriz.
     */
    public int graterThan() {
        int biggest = 0;
        for (int i = 0; i < this.integers.length; i++) {
            for (int y = 0; y < this.integers[i].length; y++) {
                if (biggest >= this.integers[i][y])
                    continue;
                biggest = this.integers[i][y];
            }
        }

        return biggest;
    }

    /*
     * Ex 02
     * Obter Menor Elemento:
     * Implemente um método que retorne o menor valor presente na matriz.
     */

    public int lowerThan() {
        int lowest = this.integers[0][0];
        for (int i = 0; i < this.integers.length; i++) {
            for (int y = 0; y < this.integers[i].length; y++) {
                if (lowest <= this.integers[i][y])
                    continue;

                lowest = this.integers[i][y];
            }
        }

        return lowest;
    }

    /*
     * Ex 03
     * Calcular Média dos Elementos:
     * Implemente um método que calcule e retorne a média aritmética dos elementos
     * da matriz.
     */
    public double average() {
        double sum = 0;
        double count = 0;

        for (int i = 0; i < this.integers.length; i++) {
            for (int y = 0; y < this.integers[i].length; y++) {
                sum += this.integers[i][y];
                count++;
            }
        }

        double average = sum / count;
        return average;
    }

    /*
     * Ex 04
     * Somar Elementos por Linha:
     * Implemente um método que retorne um array contendo a soma dos elementos de
     * cada linha da matriz.
     */
    public int[] sumByLine() {
        int[] sums = new int[this.integers.length];

        for (int i = 0; i < this.integers.length; i++) {
            int sum = 0;

            for (int y = 0; y < this.integers[i].length; y++) {
                sum += this.integers[i][y];
            }

            sums[i] = sum;
        }

        return sums;
    }

    /*
     * Ex 05
     * Somar Elementos por Coluna:
     * Implemente um método que retorne um array contendo a soma dos elementos de
     * cada coluna da matriz.
     */

    public int[] sumByColumn() {
        if (this.integers.length == 0 || this.integers[0].length == 0)
            return new int[0];

        int[] sums = new int[this.integers[0].length];

        for (int y = 0; y < this.integers[0].length; y++) {
            int sum = 0;

            for (int i = 0; i < this.integers.length; i++) {
                sum += this.integers[i][y];
            }

            sums[y] = sum;
        }

        return sums;
    }

    /*
     * Ex 06
     * Calcular Soma Total:
     * Implemente um método que calcule e retorne a soma total de todos os elementos
     * da matriz.
     */
    public int total() {
        int sum = 0;

        for (int i = 0; i < this.integers.length; i++) {
            for (int y = 0; y < this.integers[i].length; y++) {
                sum += this.integers[i][y];
            }
        }

        return sum;
    }

    /*
     * Ex 07
     * Contar Ocorrências de um Valor:
     * Implemente um método que receba um valor como parâmetro e retorne o número de
     * vezes que esse valor aparece na matriz.
     */
    public int totalOccurrencesOf(int value) {
        int total = 0;

        for (int i = 0; i < this.integers.length; i++) {
            for (int y = 0; y < this.integers[i].length; y++) {
                total += (value == this.integers[i][y]) ? 1 : 0;
            }
        }

        return total;
    }

}
