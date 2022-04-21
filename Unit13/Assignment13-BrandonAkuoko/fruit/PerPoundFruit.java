package fruit;

public class PerPoundFruit extends Fruit{
    private double weight;

    public PerPoundFruit(String name, double price, double weight){
        super(name, price);
        this.weight = weight;
    }

    @Override
    public double price() {
        return price * weight;
    }
    @Override
    public String toString() {
        return this.name +": $" + this.price + " x "  + this.weight +"lbs     $" + price();
    }
    
}
