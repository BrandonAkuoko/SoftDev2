package assignment7_1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import graphs.AdjacencyGraph;
import graphs.Graph;

public class Mothers {
    public static List<String> findMothers(Graph<String> graph, List<String> values){
        List<String> motherList = new LinkedList<>();
        List<String> fatherlist = new LinkedList<>();
        List<String> path = new LinkedList<>();

        for(String x : values){
            fatherlist.clear();
            for(String y : values){
                path = graph.bfPath(x, y);
                if(path != null){
                    fatherlist.add(y);
                }
            }

            Collections.sort(fatherlist);
            Collections.sort(values); // problem with code that solved empty set error

            if(values.equals(fatherlist)){ // List must both  be sorted the same before being checked
                if(!motherList.contains(x)){
                    motherList.add(x);

                }
            }
        }
        return motherList;
    }

    public static void main(String[] args) {
        Graph<String> graph = new AdjacencyGraph<>();
        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.add("D");
        graph.add("E");


        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        graph.connectDirected("A", "B");
        graph.connectDirected("B", "C");
        graph.connectDirected("E", "A");
        graph.connectDirected("C", "D"); 
        graph.connectDirected("B", "E");

        List<String> motherlist = findMothers(graph, list);
        System.out.println(motherlist);

        Graph<String> graph1 = new AdjacencyGraph<>();
        graph1.add("Z");
        graph1.add("U");
        graph1.add("Y");
        graph1.add("W");
        graph1.add("X");
        graph1.add("T");
        graph1.add("V");


        List<String> list1 = new LinkedList<>();
        list1.add("Z");
        list1.add("U");
        list1.add("Y");
        list1.add("W");
        list1.add("X");
        list1.add("T");
        list1.add("V");

        graph1.connectDirected("Z", "U");
        graph1.connectDirected("Z", "Y");
        graph1.connectDirected("Y", "W");
        graph1.connectDirected("W", "T");
        graph1.connectDirected("T", "V");
        graph1.connectDirected("X", "U");
        graph1.connectDirected("X", "T");
        graph1.connectDirected("Y", "X");

        List<String> motherlist1 = findMothers(graph1, list1);
        System.out.println(motherlist1);

        
    }
}
