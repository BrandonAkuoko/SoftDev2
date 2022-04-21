package lambdas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentMain {
    //inner class
    static class StudentComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {  
            return o1.getlName().compareTo(o2.getlName());
        }
    }
    public static void main (String[] args) {


        List <Student> students = new ArrayList<> ();
        students.add (new Student ("Tom", "Smith", 3.6));
        students.add (new Student ("Joe", "Zimmerman", 2.9));
        students.add (new Student ("Jack", "Brown", 3.4));
        students.add (new Student ("Emily", "Peterson", 4.0));

        // students.sort(new Comparator<Student>(){
        //     @Override
        //     public int compare(Student o1, Student o2) {  
        //         return o1.getlName().compareTo(o2.getlName());
        //     }
        // });
        // Comparator<Student> s = new StudentComparator();
        // students.sort(s);
        //students.sort((o1,o2)->{return o1.getlName().compareTo(o2.getlName());}); // lambdas expression
        students.sort(Student::compareTo); // method lambda use
        students.forEach((Student x) -> {System.out.println(x.getfName() + " " + x.getlName());}); // lambda for each loop over students 
        System.out.println (students);
    }
}
