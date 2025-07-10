import java.util.*;
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter the no of element in array: ");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter the element");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
	    }
		
		
		
		
		Set<Integer> set = new HashSet<>();
		for(int num : arr) {
			set.add(num);
		}
		int maxStreak =0;
		for(int num : arr) {
			if(!set.contains(num-1)) {
				int currNum=num;
				int currStreak=1;
				while(set.contains(currNum+1)) {
					currNum+=1;
					currStreak+=1;
				}
			maxStreak =Math.max(currStreak, maxStreak);
			}
		}
		
		System.out.print("The longest consecutive sequence is: "+maxStreak);

   }
}
