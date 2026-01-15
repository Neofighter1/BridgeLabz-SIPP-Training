package Level_1;

public class Circle {
     double radius;

 
    public Circle() {
    	
        radius =1.0; 
    }

    public Circle(double radius) {
        this.radius = radius;
    }

 
    public void display() {
        System.out.println("Radius of the circle : " + radius);
    }

 
    public static void main(String[] args) {
    	System.out.println("Defult Constructor");
        Circle defaultCircle = new Circle();
        defaultCircle.display(); 
    	System.out.println();
    	System.out.println("Perameterize Constructor");

        Circle peraCircle = new Circle(5.5);
        peraCircle.display();  
    }
}