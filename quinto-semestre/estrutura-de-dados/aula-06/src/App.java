import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] sizes = { 100, 10000, 100000 };

        for (int size : sizes) {
            System.out.println(String.format("=-=-=-= Testando arrays de tamanho %d =-=-=-=\n", size));

            int[] sortedArray = ArrayGenerator.generateSortedArray(size);
            int[] reverseArray = ArrayGenerator.generateReverseSortedArray(size);
            int[] randomArray = ArrayGenerator.generateRandomArray(size);

            System.out.println("=-=-=-= Teste com Bubble Sort =-=-=-=");

            Metric bubbleSorted = BubbleSort.sort(Arrays.copyOf(sortedArray, size));
            bubbleSorted.print("Bubble Sort (Ordenado)", size);

            Metric bubbleReverse = BubbleSort.sort(Arrays.copyOf(reverseArray, size));
            bubbleReverse.print("Bubble Sort (Reverso)", size);

            Metric bubbleRandom = BubbleSort.sort(Arrays.copyOf(randomArray, size));
            bubbleRandom.print("Bubble Sort (Aleatório)", size);

            System.out.println("=-=-=-= Teste com Selection Sort =-=-=-=");

            Metric selectionSorted = SelectionSort.sort(Arrays.copyOf(sortedArray,
                    size));
            selectionSorted.print("Selection Sort (Ordenado)", size);

            Metric selectionReverse = SelectionSort.sort(Arrays.copyOf(reverseArray,
                    size));
            selectionReverse.print("Selection Sort (Reverso)", size);

            Metric selectionRandom = SelectionSort.sort(Arrays.copyOf(randomArray,
                    size));
            selectionRandom.print("Selection Sort (Aleatório)", size);

            System.out.println("=-=-=-= Teste com Insertion Sort =-=-=-=");

            Metric insertionSorted = InsertionSort.sort(Arrays.copyOf(sortedArray,
                    size));
            insertionSorted.print("Insertion Sort (Ordenado)", size);

            Metric insertionReverse = InsertionSort.sort(Arrays.copyOf(reverseArray,
                    size));
            insertionReverse.print("Insertion Sort (Reverso)", size);

            Metric insertionRandom = InsertionSort.sort(Arrays.copyOf(randomArray,
                    size));
            insertionRandom.print("Insertion Sort (Aleatório)", size);

            System.out.println("=-=-=-= Teste com Merge Sort =-=-=-=");

            Metric mergeSorted = MergeSort.sort(Arrays.copyOf(sortedArray, size));
            mergeSorted.print("Merge Sort (Ordenado)", size);

            Metric mergeReverse = MergeSort.sort(Arrays.copyOf(reverseArray, size));
            mergeReverse.print("Merge Sort (Reverso)", size);

            Metric mergeRandom = MergeSort.sort(Arrays.copyOf(randomArray, size));
            mergeRandom.print("Merge Sort (Aleatório)", size);

            System.out.println("=-=-=-= Teste com Quick Sort =-=-=-=");

            Metric quickSorted = QuickSort.sort(Arrays.copyOf(sortedArray, size));
            quickSorted.print("Quick Sort (Ordenado)", size);

            Metric quickReverse = QuickSort.sort(Arrays.copyOf(reverseArray, size));
            quickReverse.print("Quick Sort (Reverso)", size);

            Metric quickRandom = QuickSort.sort(Arrays.copyOf(randomArray, size));
            quickRandom.print("Quick Sort (Aleatório)", size);
        }
    }
}
