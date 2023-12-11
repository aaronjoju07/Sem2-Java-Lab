
// Multilevel Inheritance

// 1.Aimal->Super Class
// 2.Dog extends Animal
// 3.Laberdog extends Dog

// Animal
//   |
//  Dog
//   |
// LaberDog
class Animal {
    String Atype;
    public Animal(String Atype){
        this.Atype=Atype;
    }
    void eat() {
        System.out.println("Animal Type :"+Atype);
    }
}

/**
 * Dog
 */
class Dog extends Animal {
    String Dtype;
    public Dog(String Atype,String Dtype){
        super(Atype);
        this.Dtype = Dtype;
    }
    void barks() {
        System.out.println("Dog Type : "+Dtype);
    }
}

/**
 * LaberDog
 */
class LaberDog extends Dog {
    String color;
    public LaberDog(String Atype,String Dtype,String color){
        super(Atype,Dtype);
        this.color=color;
    }
    void color() {
        System.out.println("Color : "+color);
    }
}

/**
 * Main
 */
public class MultilevelInheritance {
    public static void main(String[] args) {
        LaberDog ld = new LaberDog("Dog","LaberDog","White");
        ld.eat();
        ld.barks();
        ld.color();
    }
}