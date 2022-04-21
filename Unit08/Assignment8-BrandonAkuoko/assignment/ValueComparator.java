package assignment;

import java.util.Comparator;

public class ValueComparator implements Comparator<Course> {
    @Override
    public int compare(Course o1, Course o2) {
        return o1.getEnd() - o2.getEnd();
    }
}
