package graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WVertex<E> {
    private E value;
    private Map<WVertex<E>, Edge<E>> neighbors;

    public WVertex(E value) {
        this.value = value;
        neighbors = new HashMap<>();
    }

    public E getValue() {
        return value;
    }

    public void connect(WVertex<E> neighbor, double weight) {
        Edge<E> edge = new Edge<>(this, neighbor, weight);
        neighbors.put(neighbor, edge);
    }

    public Edge<E> edge(WVertex<E> neighbor){
        return neighbors.get(neighbor);
    }
    public Set<Edge<E>> edges(){
        //TO DO - Treeset of edges
        Set<Edge<E>> edges = new TreeSet<>();
        for(Edge<E> e : neighbors.values()){
            edges.add(e);

        }
        return edges;
    }
    public String toString() {
        return value.toString();
    }
    
}
