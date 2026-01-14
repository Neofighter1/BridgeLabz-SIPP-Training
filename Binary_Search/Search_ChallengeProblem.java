
import java.util.Arrays;

public class Search_ChallengeProblem {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int n = arr.length;
        boolean[] present = new boolean[n + 1];
        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                System.out.println("First Missing Positive: " + i);
                break;
            }
        }

        Arrays.sort(arr);
        int target = 1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                System.out.println("Found at Index: " + mid);
                return;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Not Found");
    }
}
