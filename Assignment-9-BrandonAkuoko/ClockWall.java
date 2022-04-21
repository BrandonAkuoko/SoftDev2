import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ClockWall {
    private interface Clock {String getTime();}

    public static void main(String[] args) {
        Map<String, Clock> clocks = new HashMap<>();
        clocks.put("Rochester", ()->{
            LocalTime now = LocalTime.now((ZoneOffset.UTC));
            int hour = now.getHour() - 4;
            int min = now.getMinute();
            return hour + ":" + min;
        });
        clocks.put("Chicago", ()->{
            LocalTime now = LocalTime.now((ZoneOffset.UTC));
            int hour = now.getHour() - 5;
            int min = now.getMinute();
            return hour + ":" + min;
        });
        clocks.put("London", ()->{
            LocalTime now = LocalTime.now((ZoneOffset.UTC));
            int hour = now.getHour() + 1;
            int min = now.getMinute();
            return hour + ":" + min;
        });
        clocks.put("Seattle", ()->{
            LocalTime now = LocalTime.now((ZoneOffset.UTC));
            int hour = now.getHour() - 7;
            int min = now.getMinute();
            return hour + ":" + min;
        });
        for (Map.Entry<String, Clock> e : clocks.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue().getTime());
        }
    }
    
}
