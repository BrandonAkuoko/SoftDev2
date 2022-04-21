package activities;

class ShapePrinter{
    public static void printShape(Shape shape){
        System.out.println(shape.getName());
        System.out.println(shape.getArea());
        System.out.println(shape.getPerim());
    } 
}

class Rectangle extends AbstractShape{
    private double length;
    private double height;

    public Rectangle(double length, double height){
        super("Rectangle");
        this.length = length;
        this.height = height;
    }
    @Override
    public double getArea() {
        return length * height;
    }

    @Override
    public double getPerim() {
        return (2 * length) + (2*height);
    }
    
}
abstract class AbstractShape implements Shape{
    private String name;
    public AbstractShape(String name){this.name = name;}
    @Override
    public String getName() {
        return name;
    }
}
class Circle extends AbstractShape{
    private double r;

    public Circle(double r){
        super("Circle");
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public double getPerim() {
        return 2*Math.PI*r;
    }
    
}
class Square extends Rectangle{

    public Square(double length) {
        super(length, length);
        
    }
    
}


public interface Shape {
    public String getName();
    public double getArea();
    public double getPerim();
}
