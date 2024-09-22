public class SelectionSort {
    public static Metric sort(int[] array) {
        Metric metric = new Metric();
        int size = array.length;
        long startTime = System.nanoTime();

        for (int index = 0; index < size - 1; index++) {
            int indexOfTheSmallestElementFound = index;

            for (int i = index + 1; i < size; i++) {
                metric.setComparisons(metric.getComparisons() + 1);

                boolean isCurrentElementLowerThanSmallestElementFound = array[i] < array[indexOfTheSmallestElementFound];
                if (isCurrentElementLowerThanSmallestElementFound) {
                    indexOfTheSmallestElementFound = i;
                }
            }

            if (indexOfTheSmallestElementFound != index) {
                int temp = array[index];

                array[index] = array[indexOfTheSmallestElementFound];
                array[indexOfTheSmallestElementFound] = temp;

                metric.setSwaps(metric.getSwaps() + 1);
            }
        }

        metric.setTime(System.nanoTime() - startTime);

        return metric;
    }
}
