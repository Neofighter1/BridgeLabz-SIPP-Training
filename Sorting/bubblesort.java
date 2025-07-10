package Sorting;
public class bubblesort {
    public static void main(String[] args) {
        int data[]={4,7,2,9,34,8796,32};
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data.length-1;j++){
                if(data[j]>data[j+1]){
                    int temp=data[j+1];
                    data[j+1]=data[j];
                    data[j]=temp;
                }
            }
        }
        for(int i:data){
            System.out.print(i+" ");
        }
    }
}
