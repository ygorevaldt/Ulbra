public class Metric {
    private long comparisons = 0;
    private long swaps = 0;
    private long time = 0;

    public void print(String algorithmName, int size) {
        System.out.println(String.format("%s - Tamanho %d", algorithmName, size));
        System.out.println(String.format("Comparações: %d", comparisons));
        System.out.println(String.format("Trocas: %d", swaps));
        System.out.println(String.format("Tempo: %d nanosegundos", time));
        System.out.println();
    }

    public void setComparisons(long comparisons) {
        this.comparisons = comparisons;
    }

    public void setSwaps(long swaps) {
        this.swaps = swaps;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getTime() {
        return time;
    }

}
