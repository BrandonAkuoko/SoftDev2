package bst;

import java.util.ArrayList;
import java.util.List;

import graphs.AdjacencyGraph;
import graphs.Graph;
import graphs.AdjacencyGraph;

public class BstAsGraph {
    private BinaryNode node;
    private Graph<Integer> graph;
    public static ArrayList<Integer> list = new ArrayList<>();


    public BinaryNode makeBTS(int[] array){
        node = new BinaryNode(array[0]);
        for(int i = 1; i < array.length; i++){
            node.binaryInsert(array[i]);
        }
        return node;
    }


    public Graph<Integer> convertToGraph(BinaryNode node){
        List<Integer> list = readFromTree(node);
        list.add(node.getValue());
        graph = new AdjacencyGraph<>();
        graph.add(node.getValue());

        for(int i : list){
            graph.add(i);
        }
        for(int x : list){
            for(int y : list){
                if(x != y){
                    graph.connectUndirected(x, y);
                }
            }
        }

        return graph;
    }


    private ArrayList<Integer> readFromTree(BinaryNode node){
        if(node.getLeft() != null){
            readFromTree(node.getLeft());
            list.add(node.getLeft().getValue());
        }
        if(node.getRight() != null){
            readFromTree(node.getRight());
            list.add(node.getRight().getValue());
        }
        return list;
    }
}