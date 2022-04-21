package gvt;
/*
Inheritance
Parent/Super class
Child/Sub class
Child class inherits state and behavior of the parent class
Reuse
Polymorphism - any code written to use Parent which also works with child 
e.g parentObj.behavior(), childObject.behavior()
*/

class Person{
    private String name;
    public Person(String name){
        this.name = name;

    }
    public String getName(){return name;}

    public void setName(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return "name = " + name;
    }
    public void todo(){
        System.out.print("Sleep");
    }
}
class Student extends Person{ // Student is the child of Person
    private double gpa;
    //1. Must define a constructor
    // must call the super class constructor should be done first 
    public Student(String name, double gpa){
        super(name);
        this.gpa = gpa;

    }
    @Override
    public String toString(){
        return super.toString() + ", gpa = " + this.gpa;
    }
    @Override
    public void todo(){
        System.out.println("Do homework");
    }

    
}

public class Inheritance {
    public static void main(String[] args) {
        Student stud = new Student("Brandon", 3.0);
        // String name = stud.getName();
        // stud.setName("Bobby");
        // System.out.println(stud.toString()); // name = Bobby, gpa = 3.0
        Person person = stud;
        System.out.println(person.toString()); // JVM will use the toString method in the Students to run 
        person.todo(); // do homework
    }
    
}
