public class Matriz {
    private int[][] integers;
    private int matrizSize;
    private int vetorSize;
    private int positionsAmount;
    private int amountOfItemsAdded = 0;

    public Matriz(int matrizSize, int vetorSize) {
        this.integers = new int[matrizSize][vetorSize];
        this.matrizSize = matrizSize;
        this.vetorSize = vetorSize;

        this.positionsAmount = this.vetorSize * this.matrizSize;
    }

    // Exercício 1
    // a) e b) Inserção de elementos
    public void add(int item) {
        if (this.amountOfItemsAdded >= this.positionsAmount) {
            System.out.println("Matriz is full");
            return;
        }

        for (int index = 0; index <= this.getLastIndex(); index++) {
            for (int vetorIndex = 0; vetorIndex < this.integers[index].length; vetorIndex++) {
                if (this.integers[index][vetorIndex] != 0)
                    continue;

                this.integers[index][vetorIndex] = item;
                this.amountOfItemsAdded++;
                return;

            }
        }
    }

    // c) Remoção de elementos por posição.
    public void remove(int row, int column) {
        if (row > this.getLastIndex()) {
            System.out.println(String.format("Row '%d' is not exists", row));
            return;
        }

        if (this.integers[row][column] == 0) {
            System.out.println(String.format("Element of column '%d' row '%d' is not exists", column, row));
            return;
        }

        this.integers[row][column] = 0;

        this.rearrangeArray();
    }

    // d) Exibição da matriz
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= this.getLastIndex(); i++) {
            for (int j = 0; j < this.integers[i].length; j++) {
                sb.append(this.integers[i][j]);
                if (j < this.integers[i].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    // Exercicio 2 - Ordenação
    // c) Ordenar matriz completa
    public void bubbleSort() {
        boolean swapped;

        do {
            swapped = false;
            int totalLength = this.integers.length * this.integers[0].length;

            for (int i = 0; i < totalLength - 1; i++) {
                int rowIndex1 = i / this.integers[0].length;
                int colIndex1 = i % this.integers[0].length;
                int rowIndex2 = (i + 1) / this.integers[0].length;
                int colIndex2 = (i + 1) % this.integers[0].length;

                if (this.integers[rowIndex1][colIndex1] > this.integers[rowIndex2][colIndex2]) {
                    int temp = this.integers[rowIndex1][colIndex1];
                    this.integers[rowIndex1][colIndex1] = this.integers[rowIndex2][colIndex2];
                    this.integers[rowIndex2][colIndex2] = temp;

                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Método principal para ordenar a matriz usando Merge Sort
    public void mergeSort(MergeSortOptions option) {
        if (option == MergeSortOptions.ROW) {
            // Ordena as linhas individualmente
            for (int i = 0; i < this.integers.length; i++) {
                mergeSortRow(this.integers[i], 0, this.integers[i].length - 1);
            }
        } else if (option == MergeSortOptions.COLUMN) {
            // Ordena as colunas individualmente
            for (int j = 0; j < this.integers[0].length; j++) {
                // Extrai uma coluna, ordena e coloca de volta na matriz
                int[] column = extractColumn(this.integers, j);
                mergeSortRow(column, 0, column.length - 1);
                insertColumn(this.integers, column, j);
            }
        }
    }

    // Método Merge Sort para um array unidimensional (linha ou coluna)
    private void mergeSortRow(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSortRow(array, left, middle);
            mergeSortRow(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    // Função auxiliar para mesclar duas sub-partes de um array
    private void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copia os dados para arrays temporários
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Mescla os arrays temporários de volta ao array original
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes de leftArray (se houver)
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copia os elementos restantes de rightArray (se houver)
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Extrai uma coluna da matriz como um array
    private int[] extractColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }

    // Insere uma coluna de volta na matriz após a ordenação
    private void insertColumn(int[][] matrix, int[] column, int colIndex) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][colIndex] = column[i];
        }
    }

    public int[][] getIntegers() {
        return this.integers;
    }

    private void rearrangeArray() {
        int[][] newMatrix = new int[this.matrizSize][this.vetorSize];
        int newRowIndex = 0;

        for (int i = 0; i <= this.getLastIndex(); i++) {
            int newColIndex = 0;
            for (int j = 0; j < this.integers[i].length; j++) {
                if (this.integers[i][j] == 0)
                    continue;

                newMatrix[newRowIndex][newColIndex] = this.integers[i][j];
                newColIndex++;
            }
            if (newColIndex > 0) {
                newRowIndex++;
            }
        }

        this.integers = newMatrix;
    }

    private int getLastIndex() {
        return this.integers.length - 1;
    }
}
