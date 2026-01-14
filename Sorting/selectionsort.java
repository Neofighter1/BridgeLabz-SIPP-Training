package Sorting;

public class selectionsort {
    public static void main(String[] args) {
        int data[]={4,7,2,9,34,8796,32};
        for(int i=0;i<data.length-1;i++){
            int min=i;
            for(int j=i;j<data.length;j++){
                if(data[j]<data[min])min=j;
            }
            int temp=data[i];
            data[i]=data[min];
            data[min]=temp;
        }
        for(int i:data)System.out.print(i+" ");
    }
}
