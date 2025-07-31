import java.util.*;
public class Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fact = new int[10];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (count == fact.length) {
                    int[] temp = new int[fact.length * 2];
                    System.arraycopy(fact, 0, temp, 0, fact.length);
                    fact = temp;
                }
                fact[count++] = i;
            }
        }
        for (int i = 0; i < count; i++) System.out.print(fact[i] + " ");
    }
}