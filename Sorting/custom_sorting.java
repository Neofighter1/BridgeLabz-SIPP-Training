package Sorting;
public class custom_sorting {
    public static int max(int arr[],boolean check[]){
        int max=Integer.MIN_VALUE;
        int maxindex=-1;
        for(int i=0;i<arr.length;i++){
            if(!check[i] && arr[i]>max){
                max=arr[i];
                maxindex=i;
            }
        }
        return maxindex;
    }
    public static int []sorted(int arr[]){
        boolean check[]=new boolean[arr.length];
        int sort[]=new int [arr.length];
        for(int i=0;i<arr.length;i++){
            int maxindex=max(arr,check);
            sort[i]=arr[maxindex];
            check[maxindex]=true;
        }
        return sort;
    }
    public static void main(String[] args) {
        int arr[]={6,2,8,1,8};
        arr=sorted(arr);
        for(int i:arr){
            System.out.println(i+" ");
        }
    }
}
