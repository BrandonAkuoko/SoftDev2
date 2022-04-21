package fruit;

public class PerUnitFruit extends Fruit{
    private int count;
    
    public PerUnitFruit(String name, double price, int count){
        super(name, price);
        this.count = count;
    }


    @Override
    public double price() {
        return price * count;
    }
    @Override
    public String toString() {
        return this.name +": $" + this.price + " x "  + this.count +"     $" + price();
    }
    
}
