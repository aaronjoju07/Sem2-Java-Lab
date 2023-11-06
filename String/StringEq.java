
public class StringEq {

    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        char ch[] = { 'j', 'a', 'v', 'a' };
        String s3 = new String(ch);
        // Equals
        System.out.println(s2.equals(s3));
        System.out.println(s1.equals(s3));
        // ==
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        // compareTo
        System.out.println(s1.compareTo(s3));
    }

}
