public class Lab2 {
    // Write a Java program to create String using StringBuffer class and implement
    // the following methods .
    // 1. append()
    // 2. insert()
    // 3. replace()
    // 4. delete()
    // 5. charAt()
    // 6.setCharAt()
    // 7.length()
    // 8.capacity()
    // 9.ensureCapacity()
    // 10.toString()
    // 11.substring(int start)
    // 12. substring(int start, int end)
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("hello world");

        System.out.println("StringBuffer append " + buffer.append(" null"));

        System.out.println("StringBuffer inserted " + buffer.insert(11, "null"));

        System.out.println("StringBuffer replace " + buffer.replace(1, 3, "java"));

        System.out.println("StringBuffer deleted " + buffer.delete(1, 3));

        System.out.println("StringBuffer CharAt " + buffer.charAt(1));
        buffer.setCharAt(3, 'r');
        System.out.println("StringBuffer setCharAt " + buffer);
        int len = buffer.length();
        System.out.println("StringBuffer setCharAt " + len);
        System.out.println("StringBuffer capacity " + buffer.capacity());
        buffer.ensureCapacity(30);
        System.out.println("StringBuffer ensureCapacity " + buffer.capacity());
        System.out.println("StringBuffer toString " + buffer.toString());
        System.out.println("StringBuffer substring(int start) " + buffer.substring(4));
        System.out.println("StringBuffer substring(int start, int end) " + buffer.substring(4,7));

    }
}
