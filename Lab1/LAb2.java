public class LAb2 {
    String str ;
    String str1 ;
    String str2;
    public LAb2() {
        this.str = "We realizes that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative. The alternative mentioned here is the Tata Nano, which soon after came as the world’s cheapest car on retail at a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a recent post by Humans of Bombay which formed the basis of his decision to come up with a car like Tata Nano.";
        this.str1  = "The paragraph is %s";
    this.str2 = "The paragraph is ";
    }

    public static void main(String[] args) {
      
        // Java String Methods
        LAb2 lb = new LAb2();
        System.out.println(lb.str.charAt(9));
        System.out.println(lb.str.compareTo("We realizes that while our workers were thriving"));
        System.out.println(lb.str.concat("null"));
        System.out.println(lb.str.contains("the surrounding villages were still suffering."));
        System.out.println(lb.str.endsWith("thriving"));
        System.out.println(lb.str.equals("the surrounding"));
        System.out.println(lb.str.equalsIgnoreCase(lb.str));
        System.out.println(String.format(lb.str1, lb.str));
        System.out.println(lb.str.getBytes());
        char[] destArray = new char[20];
        lb.str.getChars(12, 25, destArray, 0);
        System.out.println(destArray);
        System.out.println(lb.str.indexOf("realizes"));
        System.out.println(lb.str.intern());
        System.out.println(lb.str.isEmpty());
        System.out.println(String.join("-",lb.str2, lb.str));
        System.out.println(lb.str.lastIndexOf("surrounding"));
        System.out.println(lb.str.length());
        System.out.println(lb.str1.replace(lb.str1,lb.str2));
        System.out.println(lb.str1.replaceAll(lb.str1,lb.str2));
        String[] arrOfStr = lb.str.split(".", 2);
 
        for (String a : arrOfStr)
            System.out.println(a);
        System.out.println(lb.str.startsWith("We")); 
        System.out.println(lb.str.substring(10)); 
        char[] charArr = lb.str.toCharArray();
        System.out.println(charArr);
        System.out.println(lb.str.toLowerCase());
        System.out.println(lb.str.toUpperCase());
        System.out.println("trim");
        System.out.println(lb.str.trim());
        String s6 = String.valueOf(30);
        System.out.println(10 + s6);
    }
}
