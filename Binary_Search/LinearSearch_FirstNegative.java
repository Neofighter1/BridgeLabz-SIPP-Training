
public class LinearSearch_FirstNegative {
    public static void main(String[] args) {
        int[] arr = {4, 7, -3, 5, 9};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                System.out.println("Index: " + i);
                return;
            }
        }
        System.out.println("-1");
    }
}
