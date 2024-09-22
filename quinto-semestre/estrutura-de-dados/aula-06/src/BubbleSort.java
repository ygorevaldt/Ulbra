public class BubbleSort {
    public static Metric sort(int[] array) {
        Metric metric = new Metric();
        int size = array.length;
        long startTime = System.nanoTime();

        for (int index = 0; index < size - 1; index++) {
            for (int i = 0; i < size - index - 1; i++) {
                metric.setComparisons(metric.getComparisons() + 1);

                boolean isLeftItemGreaterThanRightItem = array[i] > array[i + 1];
                if (isLeftItemGreaterThanRightItem) {
                    int temp = array[i];

                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    metric.setSwaps(metric.getSwaps() + 1);
                }
            }
        }

        metric.setTime(System.nanoTime() - startTime);

        return metric;
    }
}
