package preactivity;
/*
1. Difference between static and non-static
2. Constant
3. enum
4. Special methods - toString()
5. throw exception
6.UML
*/

public class Student {
    //1. States, field, data members
    private String name; // static vs instance?
    private int age;
    private static final String SCHOOL = "RIT";
    private static int numStudents = 0; // shared by all objects

    private Work work;

    
    public Student(String name, int age){ // overload constructor
        this.name = name;
        this.age = age;
        if(age < 17){
            throw new IllegalArgumentException("That jawn too young");
        }
        numStudents += 1;
        work = Work.SLEEP;


    }
    public static int getNumStudents(){
        return numStudents;
    }
    public static String getSchool(){
        return SCHOOL;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;

    }
    @Override
    public String toString(){
        return name + ", " + age;
    }
    @Override
    public boolean equals(Object another){
        //this vs another
        if(!(another instanceof Student)){
            return true;
        }
        // this.name vs anotherStudent.name && this.age vs anotherStudent.age
        Student anotherStudent = (Student) another;
        return this.name.equals(anotherStudent.name) && this.age == anotherStudent.age;

       
    }

}

