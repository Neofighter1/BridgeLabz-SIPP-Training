import java.util.*;
class Spring_Season{
    public static void main(String [] ars){
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        if(month == 3 && day >= 20 && day<=31 || month == 4 && day>=1 && day<=30|| month == 5 && day>=1 && day<=31 || month == 6 && day < 21){
            System.out.println("Its a Spring Season");
        } 
        else {
            System.out.println("Not a Spring Season");
        }
    }
} 