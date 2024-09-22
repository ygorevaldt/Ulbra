import java.util.Random;

public class ArrayGenerator {
    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];

        for (int index = 0; index < size; index++) {
            array[index] = index + 1;
        }

        return array;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];

        for (int index = 0; index < size; index++) {
            array[index] = size - index;
        }

        return array;
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int index = 0; index < size; index++) {
            int bound = size;
            array[index] = random.nextInt(bound);
        }

        return array;
    }
}
