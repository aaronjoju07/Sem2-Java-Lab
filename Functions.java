public class Functions {
    String name;
    public Functions() {
        this.name = "Arnnnnnn Functions";   
    }
    public static void main(String[] args) {
        Functions f = new Functions();
        String fname = f.name;
        System.out.println(fname.length());    
        System.out.println(fname.charAt(2));
        System.out.println(fname.compareTo("Arnnnnn Functions"));
        System.out.println(fname.isEmpty());
        System.out.println(fname.replace('n','o'));
        System.out.println(fname.hashCode());
        System.out.println(fname.toUpperCase());
        System.out.println(fname.toLowerCase());
    }
}
