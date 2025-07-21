class private_constructor {
    private int a;
    private int b;
    private private_constructor(int a,int b){
        this.a=a;
        this.b=b;
    }
    public static private_constructor test(){
        private_constructor data=new private_constructor(4, 7);
        System.out.print(data.a+data.b);
        return data;
    }
}
public class privateconstructor{
    public static void main(String[] args) {
        private_constructor data=private_constructor.test();
    }
}
