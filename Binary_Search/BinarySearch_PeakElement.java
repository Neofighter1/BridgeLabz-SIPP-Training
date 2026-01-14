
public class BinarySearch_PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean leftCond = mid == 0 || arr[mid] > arr[mid - 1];
            boolean rightCond = mid == arr.length - 1 || arr[mid] > arr[mid + 1];
            if (leftCond && rightCond) {
                System.out.println("Peak Element: " + arr[mid]);
                return;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
}
