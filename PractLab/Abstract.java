

public class Abstract {
    public static void main(String[] args) {
        Square square = new Square();
        Circle circle = new Circle();
        square.display();
        square.draw();
        circle.display();
        circle.draw();
        FinalShape finalShape = new FinalShape();
        finalShape.display();
    }
}

abstract class Shape {
    abstract void draw();

    void display() {
        System.out.println("Displaying Shape");
    }
}

final class Circle extends Shape {
    void draw() {
        System.out.println("Draw a Circle");
    }
}

final class Square extends Shape {
    void draw() {
        System.out.println("Draw a Square");
    }
}

final class FinalShape{
    void display(){
        System.out.println("Finish Displaying");
    }
}