package binary;

import java.util.Comparator;

public class PokemonComparator implements Comparator<Pokemon>{

    @Override
    public int compare(Pokemon o1, Pokemon o2) {
        // TODO Auto-generated method stub
        return o1.getName().compareTo(o2.getName());
    }
    
}
