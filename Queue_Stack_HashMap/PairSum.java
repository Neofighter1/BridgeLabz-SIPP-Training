import java.util.*;
public class PairSum {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the no of elelments: ");
		int n= sc.nextInt();
		int arr[]= new int[n];
		System.out.print("Enter the target value: ");
		int t=sc.nextInt();
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++) {
			int remaining = t-arr[i];
			map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
		}
		
		
		boolean flag= false;
		for(int i=0;i<n;i++) {
			int remaining = t-arr[i];
			if(map.containsKey(remaining)) {
				if(remaining == arr[i] && map.get(arr[i])<2) {
					continue;
					
				}
				System.out.print("Found pair for target value : "+ arr[i]+ " , "+(t-arr[i]));
				flag=true;
				break;
			}
			
		}
		if(!flag) {
			System.out.print("The target sum is not available in this array");
		}
		
		
	}
}
