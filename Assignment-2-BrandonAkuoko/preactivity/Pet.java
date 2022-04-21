package preactivity;

public class Pet {
    //1. States, field, data members
    private String name; // static vs instance?
    private int age;

    //2. Methods
    /*Constructor
    1. Constructor name = class name
    2. no return type
    3. Used to create Pet object - allocates memory
    we initalize fields

    there is a default constructor 
    is created implicitly: - only if there is no constructor defined by the programmer
    //assertEquals(e, a, delta)
    public Pet(){
        // empty in itself
    }
    */
    public Pet(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Pet(int age){ // overload constructor
        // this.name = "unknown";
        // this.age = age;
        this("unknown", age);

    }
    public Pet(){ // overload constructor
        // this.name = "unknown";
        // this.age = 0;
        this("unknown", 0);

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
}
