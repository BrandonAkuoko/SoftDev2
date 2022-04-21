package lambdas;
import java.util.*;
public class Student implements Comparable<Student>{
    private final String fName;
    private final String lName;
    private double gpa;

    public Student (String fName, String lName, double gpa) {
        this.fName = fName;
        this.lName = lName;
        this.gpa = gpa;
    }

    public String getfName () {
        return fName;
    }

    public String getlName () {
        return lName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString () {
        return lName + "," + fName;
    }

    @Override
    public int compareTo(Student o) {
        return this.lName.compareTo(o.lName);
    }
    
}
