package lambdas;

public class ShapeExample {

    @FunctionalInterface
    public interface Shape {
        double area (double length);
    }

    public static double triangleArea (double side) {
        return Math.sqrt(3) * Math.pow (side, 2) / 4;
    }

    public static void main (String[] args) {
        int length = 5;

        // Shape square = new Shape(){
        //     @Override
        //     public double area(double length) {
        //         return length * length;
        //     }
        // };

        // lambda expression - anonymous function, can be used as a target of functional interface 
        Shape square = (l)->{return l * l;}; 

        System.out.println ("Square area = " + square.area(length));
    
        Shape circle = (r)->{return Math.PI * (r*r);};
        System.out.println ("Circle area = "+ circle.area(length));
        
        int height = 10;
        Shape rectangle = (l)-> {return height * l;};
        System.out.println ("Rectangle area = " + rectangle.area(length));

        // Shape triangle = (s)-> {return Math.sqrt(3 * Math.pow(s, 2) / 4);};
        Shape triangle = ShapeExample::triangleArea;
        
        //method reference using triangle

        System.out.println ("Triangle area = " + triangle.area(5));
        
    }  
}
