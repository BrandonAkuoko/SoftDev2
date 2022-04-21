package graphs;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph<String> graph = GraphReader.readGraph("data/a_13_5.txt");
        Graph<String> graph1 = GraphReader.readGraph("data/a_22_3.txt");
        Graph<String> graph2 = GraphReader.readGraph("data/a_26_4.txt");
        Graph<String> graph13 = GraphReader.readGraph("data/a_6_1.txt");
        Graph<String> graph3 = GraphReader.readGraph("data/a_7_3.txt");
        Graph<String> graph4 = GraphReader.readGraph("data/bipartite.txt");
        Graph<String> graph5 = GraphReader.readGraph("data/k2.txt");
        Graph<String> graph6 = GraphReader.readGraph("data/k2_2.txt");
        Graph<String> graph7 = GraphReader.readGraph("data/k3.txt");
        Graph<String> graph8 = GraphReader.readGraph("data/k3_3.txt");
        Graph<String> graph9 = GraphReader.readGraph("data/k4.txt");
        Graph<String> graph10 = GraphReader.readGraph("data/k5.txt");
        Graph<String> graph11 = GraphReader.readGraph("data/non_bipartite.txt");
        Graph<String> graph12 = GraphReader.readGraph("data/v2.txt");

        System.out.println("a_13_5.txt connected components: " + graph.countConnectedComponents());
        System.out.println("a_22_3.txt connected components: " + graph1.countConnectedComponents());
        System.out.println("a_26_4.txt connected components: " + graph2.countConnectedComponents());
        System.out.println("a_6_1.txt connected components: " + graph13.countConnectedComponents());
        System.out.println("a_7_3.txt connected components: " + graph3.countConnectedComponents());
        System.out.println("bipartite.txt connected components: " + graph4.countConnectedComponents()); // incorrected dont know why
        System.out.println("k2.txt connected components: " + graph5.countConnectedComponents());
        System.out.println("k2_2.txt connected components: " + graph6.countConnectedComponents()); // incorrect not sure why either
        System.out.println("k3.txt connected components: " + graph7.countConnectedComponents());
        System.out.println("k3_3.txt connected components: " + graph8.countConnectedComponents()); // incorrect too not sure why either
        System.out.println("k4.txt connected components: " + graph9.countConnectedComponents());
        System.out.println("k5.txt connected components: " + graph10.countConnectedComponents());
        System.out.println("non_bipartite.txt connected components: " + graph11.countConnectedComponents()); // incorrect as well dont know why 
        System.out.println("v2.txt connected components: " + graph12.countConnectedComponents());
        
        
    }
}
