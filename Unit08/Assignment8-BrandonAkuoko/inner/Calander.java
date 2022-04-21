package inner;

import java.util.*;

public class Calander {
    public enum DayOfWeek {
      
        SUNDAY(0, "Sun"), MONDAY(1, "Mon"), TUESDAY(2, "Tue"), WEDNESDAY(3, "Wed"), THURSDAY(4, "Thu"),FRIDAY(5, "Fri"), SATURDAY(6, "Sat"); 
    
        private final int number;
        private final String shortName;
        private static final Map<DayOfWeek, DayOfWeek> NEXT_DAYS = new HashMap<>();
        static{
            NEXT_DAYS.put(SUNDAY, MONDAY);
            NEXT_DAYS.put(MONDAY, TUESDAY);
            NEXT_DAYS.put(TUESDAY, WEDNESDAY);
            NEXT_DAYS.put(WEDNESDAY, THURSDAY);
            NEXT_DAYS.put(THURSDAY, FRIDAY);
            NEXT_DAYS.put(FRIDAY, SATURDAY);
            NEXT_DAYS.put(SATURDAY, SUNDAY);
        }
        private DayOfWeek(int number, String shortName) {
            this.number = number;
            this.shortName = shortName;
        }

        public DayOfWeek tomorrow() {
            return NEXT_DAYS.get(this);
        }
        @Override
        public String toString() {
            return shortName;
        }
    }
    public enum Month implements Iterable<DayOfWeek>{
        JANUARY (31), FEBRUARY (28), MARCH (31), APRIL (30), MAY (31), JUNE (30), 
        JULY (31), AUGUST (31), SEPTEMBER (30), OCTOBER (31), NOVEMBER (30), DECEMBER (31);

        private int daysInMonth;
        private DayOfWeek startDay;
        private static final Map<Month, Month> NEXT_MONTHS = new HashMap<>();
        static {
            NEXT_MONTHS.put(JANUARY, FEBRUARY);
            NEXT_MONTHS.put(FEBRUARY, MARCH);
            NEXT_MONTHS.put(MARCH, APRIL);
            NEXT_MONTHS.put(APRIL, MAY);
            NEXT_MONTHS.put(MAY, JUNE);
            NEXT_MONTHS.put(JUNE, JULY);
            NEXT_MONTHS.put(JULY, AUGUST);
            NEXT_MONTHS.put(AUGUST, SEPTEMBER);
            NEXT_MONTHS.put(SEPTEMBER, OCTOBER);
            NEXT_MONTHS.put(OCTOBER, NOVEMBER);
            NEXT_MONTHS.put(NOVEMBER, DECEMBER);
            NEXT_MONTHS.put(DECEMBER, JANUARY);
        }

        private Month(int daysInMonth){
            this.daysInMonth = daysInMonth;
        }
        public void setStartDay(DayOfWeek startDay){
            this.startDay = startDay;
        }
        public Month nextMonth(){
            return NEXT_MONTHS.get(this);
        }
        @Override
        public Iterator<DayOfWeek> iterator(){
            class MonthIterator implements Iterator<DayOfWeek>{
                private DayOfWeek day = startDay;
                private int count = 1;

                @Override
                public boolean hasNext(){
                    return count <= daysInMonth;
                }
                @Override
                public DayOfWeek next(){
                    DayOfWeek temp = day;
                    day = day.tomorrow();
                    count++;
                    return temp;
                }
            }
            return new MonthIterator();
        }
    }
    public static DayOfWeek printMonth (Month month, DayOfWeek startDay) {
        month.setStartDay (startDay);
        DayOfWeek lastDay = null;
        int counter = 1;
        System.out.println (month.name ());
        for (int i = 0; i < startDay.number; i++) {
            System.out.print (String.format("%7s", ""));
            counter++;
        }

        int dayNumber = 1;
        for (DayOfWeek day : month) {
            String out = dayNumber + "-" + day + " ";
            System.out.print (String.format("%7s", out));
            if (counter % 7 == 0) {
                System.out.println ();
            }
            lastDay = day;
            counter++;
            dayNumber++;
        }
        if (--counter % 7 != 0) {
            System.out.println ();
        }
        System.out.println ();
        return lastDay.tomorrow ();
    }
    public static DayOfWeek printYear (int year, DayOfWeek startDay) {
        Month month = Month.JANUARY;
        System.out.println (year);
        for (int i = 0; i < Month.values().length; i++) {
            startDay = printMonth (month, startDay);
            month = month.nextMonth ();
        }
        return startDay;
    }
    public static void main(String[] args) {
        //printMonth (Month.MARCH, DayOfWeek.SUNDAY);
        printYear (2021, DayOfWeek.FRIDAY);
    }
 
}
