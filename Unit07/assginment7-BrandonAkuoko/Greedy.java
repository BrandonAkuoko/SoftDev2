import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import activities.Currency;
import knapsack.Item;
import knapsack.ItemSets;
import knapsack.Knapsack;
import knapsack.ValueComparator;

public class Greedy {
    public static void main(String[] args) {
        // System.out.println(makeChange(2.37, 10)); // $7.63
        Knapsack bag = new Knapsack(10);
        packMostValuable(bag, ItemSets.sportsSet());
        System.out.println(bag);

        bag.empty();
        packLightest(bag, ItemSets.sportsSet());
        System.out.println(bag);

    }

    public static List<Currency> makeChange(double price, double payment){
        List<Currency> change = new ArrayList<>();
        double difference = payment*100 - price*100;

        //Use largest denomination first and subtract it from difference 
        // until the difference <  denomination 
        difference = countChange(Currency.DOLLAR, difference, change);
        difference = countChange(Currency.QUARTER, difference, change);
        difference = countChange(Currency.DIME, difference, change);
        difference = countChange(Currency.NICKEL, difference, change);
        difference = countChange(Currency.PENNY, difference, change);
        // System.out.println(difference);
        return change;
    }
    private static double countChange(Currency current, double difference, List<Currency> change){
        while(difference >= current.getValue()){
            change.add(current);
            difference = difference - current.getValue();

        }
        return difference;
    }
    public static Knapsack packMostValuable(Knapsack bag, List<Item> items){
        Collections.sort(items, new ValueComparator()); // sorted by value 
        //Choose the most valuable item from the list and then remove it
        while(items.size() > 0){
            Item mostItem = items.remove(0); // most valuable item is at index 0 
            bag.pack(mostItem);
        }
        return bag;
    }
    public static Knapsack packLightest(Knapsack bag, List<Item> items){
        Collections.sort(items); // sorted by weight 
        //Choose the most valuable item from the list and then remove it
        while(items.size() > 0){
            Item mostItem = items.remove(0); // most valuable item is at index 0 
            bag.pack(mostItem);
        }
        return bag;
    }
    
}
