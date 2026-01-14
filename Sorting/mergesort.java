package Sorting;
import java.util.ArrayList;

public class mergesort {
    public static void main(String[] args) {
        int data[]={4,7,2,9,34,8796,32};
        merge_sort(data,0,data.length-1);
        for(int i:data){
            System.out.print(i+" ");
        }
    }
    public static void merge_sort(int arr[],int low,int high){
        if(low>=high)return;
        int mid=(low+high)/2;
        merge_sort(arr, low, mid);
        merge_sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
    public static void merge(int arr[],int low,int mid,int high){
        // ArrayList<Integer> temp = new ArrayList<>();
        int temp[]=new int[arr.length+1];
        int i=0;
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                // temp.add(arr[left]);
                temp[i++]=arr[left];
                left++;
            }
            else{
                // temp.add(arr[right]);
                temp[i++]=arr[right];
                right++;
            }
        }
        while(left<=mid){
            // temp.add(arr[left]);
            temp[i++]=arr[left];
            left++;
        }
        while(right<=high){
            // temp.add(arr[right]);
            temp[i++]=arr[right];
            right++;
        }
        // for(int j=low;j<=high;j++){
        //     arr[j]=temp.get(j-low);
        // }
        
        for(int j=low;j<=high;j++){
            arr[j]=temp[j-low];
        }
        
    }
}
