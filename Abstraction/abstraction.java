public class abstraction {
    public static void main(String[] args) {
        Add add = new Add();
        Sub sub = new Sub();
        add.perintInfo();
        sub.perintInfo();

    }
}

abstract class arithmetic_operation {
    abstract void perintInfo();
}

class Add extends arithmetic_operation {
    void perintInfo() {
        int a = 3;
        int b = 4;
        System.out.println(a + b);
    }
}

class Sub extends arithmetic_operation {
    void perintInfo() {
        int a = 3;
        int b = 8;
        System.out.println(a + b);
    }
};