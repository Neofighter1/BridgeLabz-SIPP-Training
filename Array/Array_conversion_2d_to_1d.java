import java.util.*;
public class Array_conversion_2d_to_1d{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int[][] arr = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[] oneDArray = new int[rows * cols];
        int index = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                oneDArray[index++] = arr[i][j];
            }
        }
        for(int i=0; i<oneDArray.length; i++){
            System.out.print(oneDArray[i] + " ");
        }
    }
}