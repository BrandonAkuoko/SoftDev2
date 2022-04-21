package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ScheduleMaker {
    
    public static List<Course> makeSchedule(List<Course> courses){
        //Create a list
        // create a temporay course
        // set to the first index of the list.. Essentially the first class in the list
        // sort  the list
        // create a loop that will add the courses to the schedule
        // then it will set the temporary class to the recenttly added class
        // return the lost
        // Correct - 

        List<Course> schedule = new ArrayList<>();
        Course c = null;
        c = courses.get(0);
        Collections.sort(courses,new ValueComparator());
        for(int i = 0; i < courses.size(); i++){
            if(schedule.size() != 0){
                if(courses.get(i).getStart() >= c.getEnd()){
                    schedule.add(courses.get(i));
                    c = courses.get(i);
                }
            }
            else{
                schedule.add(courses.get(i));
                c = courses.get(i);

            }
        }
        return schedule;
    }


    public static void main(String[] args) {
        List<Course> courses = Course.exampleCourses();
        List<Course> schedule = makeSchedule(courses);
        System.out.println(schedule);

    }


}
