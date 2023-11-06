package Overriding;

class ChildMethodOverriding extends MethodOverriding{
    @Override
    void show(){
        System.out.println("Child methodOverriding");
    }
    public static void main(String[] args) {
        MethodOverriding mo = new MethodOverriding();
        ChildMethodOverriding cmo = new ChildMethodOverriding();
        mo.show();
        cmo.show();
    }
    
}