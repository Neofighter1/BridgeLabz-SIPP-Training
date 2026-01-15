// package Oops;

class Animal {
    String name;
    int age;
    void makeSound(){
        System.out.println("Its Animal");
    }
    
}
class Dog extends Animal{
    void makeSound(){
        System.out.println("Its Dog");
    }
}
class Cat extends Animal{
    void makeSound(){
        System.out.println("Its Cat");
    }
    
}
class Bird extends Animal{
        void makeSound(){
            System.out.println("Its Bird");
        }
}

public class Animal_Hierarchy{
    public static void main(String args[]){
        Animal animal=new Animal();
        animal.makeSound();
        Dog dog =new Dog();
        dog.makeSound();
        Cat cat=new Cat();
        cat.makeSound();
        Bird bird=new Bird();
        bird.makeSound();
    }
}
