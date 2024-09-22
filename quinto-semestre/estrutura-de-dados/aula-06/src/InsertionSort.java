public class InsertionSort {
    public static Metric sort(int[] array) {
        Metric metric = new Metric();
        int size = array.length;
        long startTime = System.nanoTime();

        for (int index = 1; index < size; index++) {
            int key = array[index];
            int i = index - 1;

            boolean isLeftElementGreaterThanRightElement = array[i] > key;
            while (i >= 0 && isLeftElementGreaterThanRightElement) {
                metric.setComparisons(metric.getComparisons() + 1);

                array[i + 1] = array[i];
                i--;

                metric.setSwaps(metric.getSwaps() + 1);
            }

            array[i + 1] = key;

            metric.setComparisons(metric.getComparisons() + 1);
        }

        metric.setTime(System.nanoTime() - startTime);
        return metric;
    }
}
