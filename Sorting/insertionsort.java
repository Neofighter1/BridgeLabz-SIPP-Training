package Sorting;

public class insertionsort {
    public static void main(String[] args) {
        int data[]={4,7,2,9,34};
        for(int i=0;i<data.length;i++){
            int j=i;
            while(j>0 && data[j-1]>data[j]){
                int temp=data[j-1];
                data[j-1]=data[j];
                data[j]=temp;
                j--;
            }
        }
        for(int i:data)System.out.print(i+" ");
    }
}
