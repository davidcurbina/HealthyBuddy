package co.davidurbina.haelthybuddy;

/**
 * Created by davidurbina on 4/20/17.
 */

public class Event {
    String name;
    String type;
    String day;
    String time;

    public Event(String name, String type, String day, String time ) {
        this.name=name;
        this.type=type;
        this.day=day;
        this.time=time;
    }
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
}
