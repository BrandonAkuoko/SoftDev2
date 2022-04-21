package assignment;

import graphs.WAdjacencyGraph;
import graphs.WGraph;
import graphs.WPath;

public class Word {
    public static void main(String[] args) {
        WGraph<Character> graph = new WAdjacencyGraph<>();
        graph.add('H');
        graph.add('O');
        graph.add('T');
        graph.add('D');
        graph.add('A');
        graph.add('W');
        graph.add('G');
        

        //put edges
        graph.connect('H', 'O', 100); // H O
        graph.connect('H', 'T', 12323);
        graph.connect('H', 'D', 3213234);
        graph.connect('H', 'A', 13422345);
        graph.connect('H', 'W', 545359988);
        graph.connect('H', 'G', 40000);
        graph.connect('O', 'T', 20); // H O T
        graph.connect('O', 'D', 3000);
        graph.connect('O', 'A', 4000);
        graph.connect('O', 'W', 500);
        graph.connect('O', 'G', 600);   
        graph.connect('T', 'D', 10); // H O T D
        graph.connect('T', 'A', 200);
        graph.connect('T', 'W', 300);
        graph.connect('T', 'G', 400);
        graph.connect('D', 'A', 100); // H O T D A
        graph.connect('D', 'W', 2000);
        graph.connect('D', 'G', 300);
        graph.connect('A', 'W', 100); //  H O T D A W
        graph.connect('A', 'G', 200); 
        graph.connect('W', 'G', 1); //  H O T D A W G
        
        
        WPath<Character> path = graph.dijkstrasPath('H', 'G');
        System.out.println(path);
    }
    
}
