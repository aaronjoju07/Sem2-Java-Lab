
abstract class Computer {
    public abstract void device();
}

class Desktop extends Computer {
    public void device() {
        System.out.println("Desktop");
    }
}

class Laptop extends Computer {
    public void device() {
        System.out.println("Laptop");
    }

}

class Developer {
    void devp(Computer comp) {
        System.out.println("Developer");
        comp.device();
    }

}

public class Abstract {

    public static void main(String[] args) {
        Developer dev = new Developer();
        Computer lap = new Laptop();
        Computer des = new Desktop();
        dev.devp(lap);
    }
}
