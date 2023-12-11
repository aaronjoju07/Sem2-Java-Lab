

public class Interface {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Choice ch = new Choice();
        ch.choose(cat);
    }
}
interface Animal {
    void eat();
}
class Dog implements Animal {
    public void eat() {
        System.out.println("pedigree");
    }
}
class Cat implements Animal{
    public void eat(){
        System.out.println("Meemeee");
    }
}
/**
 * Choice
 */
class Choice {
 void choose(Animal animal){
    System.out.println("Your Choice");
    animal.eat();
 }
    
}