package fruit;

public abstract class Fruit implements Cost{
    public double price;
    public String name;

    public Fruit(String name, double price){
        this.name = name;
        this.price = price;
    }
}
