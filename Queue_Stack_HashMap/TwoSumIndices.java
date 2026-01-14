import java.util.HashMap;
import java.util.Scanner;
public class TwoSumIndices {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the no of elelments: ");
		int n= sc.nextInt();
		int arr[]= new int[n];
		System.out.println("Enter the values of numbers: ");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.print("Enter the target value: ");
		int t=sc.nextInt();
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++) {
			int remaining = t-arr[i];
			map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
		}
		int idx1=-1;
		int idx2=-1;
		boolean flag= false;
		for(int i=0;i<n;i++) {
			int remaining = t-arr[i];
			if(map.containsKey(remaining)) {
				if(remaining == arr[i] && map.get(arr[i])<2) {
					continue;
					
				}
				for(int j=0;j<n;j++) {
					if(remaining==arr[j] && j!=i) {
						idx1=i;
						idx2=j;
						break;
						
					}
				}
				
				System.out.println("Found pair for target value : "+ arr[i]+ " , "+(t-arr[i]));
				System.out.println("Found pair indices of target value : "+ idx1+ " , "+idx2);

				flag=true;
				break;
			}
			
		}
		if(!flag) {
			System.out.print("The target sum is not available in this array");
		}
		
		
	}
}
