import java.util.*;
public class rocket_launch_countdown {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int counter=sc.nextInt();
        for(int i=counter;i>0;i--){
            System.out.println(i);
        }
    }
}