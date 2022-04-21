package gvt;

class Parent{
    private String name;
    public Parent(String name){
        this.name = name;
    }
    public String getName(){return name;}
    @Override
    public String toString(){
        return "{Parent name = " + name + "}";
    }
    public void printParent(String str){
        System.out.println(str);
    }
}
class Child extends Parent{
    private int age;
    public Child(String name, int age){
        super(name);
        this.age = age;
    }
    public int getAge(){return age;}
    
    @Override
    public String toString(){
        return "{Child name = " + getName() + " age = " + age + "}";
    }
    public void printChild(String str){
        System.out.println(str);
    }

}
public class Main {
    public static void main(String[] args) {
        Parent child = new Child("Tom", 18);
        //child.getAge(); // compile time error
        System.out.println(child); // will see child name and age
        Parent parent = new Parent("Thomas");
        Child child1 = new Child("Edgar", 2);
        parent.printParent("Hello");
        child1.printChild("Bye");
        
    }
    
}
