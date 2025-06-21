import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    public static void main(String[] args) {
        int N = 1_000_000;
        int[] data = new int[N];
        Random rand = new Random();

        for (int i = 0; i < N; i++) {
            data[i] = rand.nextInt(N * 10);
        }

        int target = data[rand.nextInt(N)];

        // Linear Search
        long start = System.nanoTime();
        linearSearch(data, target);
        long end = System.nanoTime();
        System.out.println("Linear Search Time: " + (end - start) / 1_000_000.0 + " ms");

        // Binary Search (after sorting)
        Arrays.sort(data);
        start = System.nanoTime();
        Arrays.binarySearch(data, target);
        end = System.nanoTime();
        System.out.println("Binary Search Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
}