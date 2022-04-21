package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student implements Comparable<Student>{
    private int id;
    private String name;

    public Student (int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student {ID: " + id + ", Name: " + name + "}";
    }

    public int getId () {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName () {
        return name;
    }

    public static void main(String[] args) {

        Student stu1 = new Student(200, "Bob");
        Student stu2 = new Student(300, "Alice");
        Student stu3 = new Student(100, "Eliot");
        Student stu4 = new Student(120, "Dave");
        Student stu5 = new Student(105, "Charlie");
        Map<String, Student> map = new HashMap<>();
        map.put(stu1.getName(), stu1);
        map.put(stu2.getName(), stu2);
        map.put(stu3.getName(), stu3);
        map.put(stu4.getName(), stu4);
        map.put(stu5.getName(), stu5);
        for(String ele : map.keySet()){
            System.out.println(map.get(ele));
        }
        
        

        //Set, Map (What happens if key changed?)
        // Set<Student> set = new HashSet<>();
        // set.add(stu1);
        // set.add(stu2);
        // set.add(stu3);
        // set.add(stu4);
        // set.add(stu5);

        // for(Student ele : set){
        //     System.out.println(ele);
        // }

    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        return this.id - o.id;
    }
}
