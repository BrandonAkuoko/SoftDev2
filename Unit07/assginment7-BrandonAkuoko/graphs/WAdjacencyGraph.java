package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WAdjacencyGraph<E> implements WGraph<E> {

    private Map<E, WVertex<E>> vertices;
    
    public WAdjacencyGraph() {
        vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        WVertex<E> vertex = new WVertex<>(value);
        vertices.put(value, vertex);

    }
    @Override
    public boolean contains(E value) {
        return vertices.containsKey(value);
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connect(E a, E b, double weight) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        vertexA.connect(vertexB, weight);
        vertexB.connect(vertexA, weight);
    }
    @Override
    public boolean connected(E a, E b) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB) != null;
    }

    @Override
    public double weight(E a, E b){
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB).getWeight();
    }


    @Override
    public WPath<E> nearestNeighbors(E start, E end) {
        //similar to dfPath
        WVertex<E> s = vertices.get(start);
        WVertex<E> e = vertices.get(end);

        Set<WVertex<E>> visited = new HashSet<>();
        visited.add(s);
        
        return visitNearestNeighbor(s, e, visited);
    }
    private WPath<E> visitNearestNeighbor(WVertex<E> startV, 
    WVertex<E> endV, Set<WVertex<E>> visited){
        //similar to visitDFPath()
        if(startV == endV) {
            WPath<E> path = new WPath<>(endV.getValue());
            return path; // [E]
        } 
        else {
            for(Edge<E> e : startV.edges()) {
                WVertex<E> neighbor = e.getTo();
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    WPath<E> path = visitNearestNeighbor(neighbor, endV, visited);
                    if(path != null) {
                        path.prepend(startV.getValue(), e.getWeight());
                        return path;
                    }
                }
            }
            return null;
        }
    }
}

