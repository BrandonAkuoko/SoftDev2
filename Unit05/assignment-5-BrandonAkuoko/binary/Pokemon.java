package binary;


import java.util.Collections;
import java.util.LinkedList;

public class Pokemon implements Comparable<Pokemon>{
    private final String name;
    private final int number;

    public Pokemon(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
    @Override
    public String toString() {
        return number + ": " + name;
    }
    @Override
    public int compareTo(Pokemon o) {
        // TODO Auto-generated method stub
        return this.number - o.number;
    }

    public static void main(String[] args) {
        LinkedList<Pokemon> pokelist = new LinkedList<>();
        pokelist.add(new Pokemon("A",3));
        pokelist.add(new Pokemon("C",2));
        pokelist.add(new Pokemon("B",1));
        System.out.println(pokelist);

        Collections.sort(pokelist); // sorts uses compareto method in the pokemon class
        System.out.println(pokelist);

        PokemonComparator comparator = new PokemonComparator();

        Collections.sort(pokelist, comparator); // sorts uses compareto method in the pokemon class
        System.out.println(pokelist);


    }

    
}
