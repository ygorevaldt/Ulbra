public class QuickSort {
    public static Metric metric;

    public static Metric sort(int[] array) {
        metric = new Metric();
        long startTime = System.nanoTime();

        quickSort(array, 0, array.length - 1);

        metric.setTime(System.nanoTime() - startTime);

        return metric;
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            metric.setComparisons(metric.getComparisons() + 1);

            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                metric.setSwaps(metric.getSwaps() + 1);
            }
        }
        int temp = array[i + 1];

        array[i + 1] = array[high];
        array[high] = temp;
        metric.setSwaps(metric.getSwaps() + 1);

        return i + 1;
    }
}
