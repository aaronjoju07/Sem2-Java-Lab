public class Alarm {
    
    protected String message;
    private boolean active;
    String phonenumber;

    public Alarm() {
        this.message = "Allam is active";
        this.active = false;
        this.phonenumber="9023982034";
    }
    public static void main(String[] args) {
        Alarm myAlam = new Alarm();
        InnerAlarmClass myClass = new InnerAlarmClass();
        myClass.snoozeClass();
        myAlam.visualize();
        myAlam.register();
    }
    
    public void visualize() {

        System.out.println("Displaying Alam ..!!");
        if (active) {
            System.out.println("Active");
        } else {
            System.out.println("NotActive");
        }

    }

    public void register() {
        this.active = true;
        System.out.println("Registering");
    }
}

