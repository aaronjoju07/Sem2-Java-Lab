package Overloading;
public class MethodWithReturnType{
    public  MethodWithReturnType(){

    }
    // without arguments
    public int add() { 
        int x = 30;
        int y = 70;
        int z = x+y;
        return z;
     }
     public static void main(String args[]) {
        MethodWithReturnType mth = new MethodWithReturnType();
        int add = mth.add();
        System.out.println("The sum of x and y is: " + add);
     }
}