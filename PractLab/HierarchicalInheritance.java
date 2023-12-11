

public class HierarchicalInheritance {
    public static void main(String[] args) {
        Dog dog = new Dog("pedigree", "bowbow");
        Cat cat = new Cat("Milk", "meow..meow..");
        System.out.println("Dog");
        dog.eat();
        dog.bark();
        System.out.println("Cat");
        cat.eat();
        cat.meow();
    }
}

/**
 * Animal
 */
class Animal {
    String food;

    public Animal(String food) {
        this.food = food;
    }

    void eat() {
        System.out.println(food);
    }
}

/**
 * Dog
 */
class Dog extends Animal {
    String bark;

    public Dog(String food, String bark) {
        super(food);
        this.bark = bark;
    }

    void bark() {
        System.out.println(bark);
    }
}

/**
 * Cat
 */
class Cat extends Animal {
    String meow;

    public Cat(String food, String meow) {
        super(food);
        this.meow = meow;
    }

    void meow() {
        System.out.println(meow);
    }

}