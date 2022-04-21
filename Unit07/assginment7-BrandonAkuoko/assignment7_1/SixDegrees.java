package assignment7_1;

import java.util.List;

import graphs.AdjacencyGraph;
import graphs.Graph;

public class SixDegrees {
    public static void main(String[] args) {
        Graph<String> graph = new AdjacencyGraph<>();
        graph.add("Infinity War");
        graph.add("Chadwick Boseman");
        graph.add("Chris Hemsworth");
        graph.add("Robert Downey Jr");
        graph.connectUndirected("Infinity War", "Chadwick Boseman");
        graph.connectUndirected("Infinity War", "Robert Downey Jr");
        graph.connectUndirected("Infinity War", "Chris Hemsworth");

        graph.add("Black Panther");
        graph.add("Michael B. Jordan");
        graph.add("Angela Bassett");
        graph.add("Martin Freeman");
        graph.connectUndirected("Black Panther", "Chadwick Boseman");
        graph.connectUndirected("Black Panther", "Michael B. Jordan");
        graph.connectUndirected("Black Panther", "Angela Bassett");
        graph.connectUndirected("Black Panther", "Martin Freeman");

        graph.add("Creed");
        graph.add("Sylvester Stallone");
        graph.add("Tessa Thompson");
        graph.add("Andre Ward");
        graph.connectUndirected("Creed", "Michael B. Jordan");
        graph.connectUndirected("Creed", "Sylvester Stallone");
        graph.connectUndirected("Creed", "Tessa Thompson");
        graph.connectUndirected("Creed", "Andre Ward");

        graph.add("Rocky");
        graph.add("Talia Shire");
        graph.add("Burt Young");
        graph.add("Carl Weathers");
        graph.connectUndirected("Rocky", "Sylvester Stallone");
        graph.connectUndirected("Rocky", "Talia Shire");
        graph.connectUndirected("Rocky", "Burt Young");
        graph.connectUndirected("Rocky", "Carl Weathers");

        List<String> bfPath = graph.bfPath("Michael B. Jordan", "Talia Shire");
        List<String> bfPath1 = graph.bfPath("Chadwick Boseman", "Burt Young");
        List<String> bfPath2 = graph.bfPath("Carl Weathers", "Chris Hemsworth");
        List<String> bfPath3 = graph.bfPath("Sylvester Stallone", "Robert Downey Jr");
        System.out.println(bfPath);
        System.out.println(bfPath1);
        System.out.println(bfPath2);
        System.out.println(bfPath3);

    }
    
}
