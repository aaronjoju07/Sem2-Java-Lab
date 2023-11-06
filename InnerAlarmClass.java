public class InnerAlarmClass extends Alarm {
    String  name;
    public  InnerAlarmClass(){
        this.name = "innerClass";
        }

        public void snoozeClass(){
            System.out.println("Snooze Alarm");
        }
    
}
