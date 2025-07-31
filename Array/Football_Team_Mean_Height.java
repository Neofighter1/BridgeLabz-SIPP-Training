import java.util.*;
public class Football_Team_Mean_Height {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];
        double sumOfHeights = 0.0;
        System.out.println("Enter the height of 11 football players (in meters, for example):");
        for (int i = 0; i < 11; i++) {
            System.out.print("Enter height for player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
            sumOfHeights += heights[i];
        }
        double meanHeight = sumOfHeights / 11;
        System.out.printf("\nSum of all heights: %.2f\n", sumOfHeights);
        System.out.printf("Mean height of the football team: %.2f\n", meanHeight);
    }
}