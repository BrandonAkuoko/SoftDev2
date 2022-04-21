package activity3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Object obj;
        String string = "Hello";
        obj = string; // every class type is an object
        obj = new Year(2021);
        Object [] object = new Object[5];
        object[0] = 2;
        object[1] = "Hello";
        object[2] = false;
        object[3] = new Year(2021);
        object[4] = 69696;
        System.out.println(Arrays.toString(object));
    }
    public static void main2(String[] args) {
        Year yearobject = new Year(2021);
        Year yearobject2 = new Year(2021);
        // System.out.println(yearobject);
        // System.out.println(yearobject.equals(yearobject2));
        
    


        String aString = "   \t\nabc d\nef";
        String trimmed = aString.trim();
        System.out.println(trimmed); //abc d
                                    //ef
        
        String aString2 = "abc de fgh";
        String[] token = aString2.split(" "); // returns an array of strings
        System.out.println(token[0]); // abc
        System.out.println(token[1]); // de
        System.out.println(token[0]); // fgh
        System.out.println(Arrays.toString(token));
    }
    
}
