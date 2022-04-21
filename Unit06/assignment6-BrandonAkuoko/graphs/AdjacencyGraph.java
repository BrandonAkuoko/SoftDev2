package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * There was a certain point where my code from class was not working this is why i had to add this file to submit
 */
public class AdjacencyGraph<E> implements Graph<E> {
    private Map<E, Vertex<E>> vertices;
    
    public AdjacencyGraph(){
        vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        Vertex<E> vertex = new Vertex<>(value);
        vertices.put(value, vertex);

    }

    @Override
    public boolean contains(E value) {return this.vertices.containsKey(value);}

    @Override
    public int size() {return vertices.size();}

    @Override
    public void connectDirected(E a, E b) {
        Vertex<E> vertexA = vertices.get(a);
        Vertex<E> vertexB = vertices.get(b);
        vertexA.connect(vertexB);
    }

    @Override
    public void connectUndirected(E a, E b) {
        Vertex<E> vertexA = vertices.get(a);
        Vertex<E> vertexB = vertices.get(b);
        vertexA.connect(vertexB);
        vertexB.connect(vertexA);

    }

    @Override
    public boolean connected(E a, E b) {
        Vertex<E> vertexA = vertices.get(a);
        Vertex<E> vertexB = vertices.get(b);
        return vertexA.connected(vertexB);
    }
    @Override
    public boolean bfSearch(E start, E end){
        //Q, set - keeps track of vertices that have seen before
        Vertex<E> startV = vertices.get(start);
        Vertex<E> endV = vertices.get(end);

        List<Vertex<E>> queue =new LinkedList<>();
        Set<Vertex<E>> visited = new HashSet<>();
        queue.add(startV);
        visited.add(startV);
        while(!queue.isEmpty()){
            Vertex<E> currV = queue.remove(0);
            if(currV == endV){
                return true;
            }
            for(Vertex<E> nbrV : currV.getNeighbors()){
                if(!visited.contains(nbrV)){ // nbrV has to be a new Vertex unless its not added
                    queue.add(nbrV);
                    visited.add(nbrV);
                }
            }
        }
        return false;
    }
    @Override
    public int countConnectedComponents() {
        Set<Vertex<E>> visited = new HashSet<>();
        int count = 0;
        for(Vertex<E> startV : vertices.values()){
            if(!visited.contains(startV)){
                count += 1;
                LinkedList<Vertex<E>> queue = new LinkedList<>();
                queue.add(startV);
                visited.add(startV);
                while(!queue.isEmpty()){
                    Vertex<E> currV = queue.poll();
                    for(Vertex<E> nbrV : currV.getNeighbors()){
                        if(!visited.contains(nbrV)){ // nbrV has to be a new Vertex unless its not added
                            queue.add(nbrV);
                            visited.add(nbrV);
                        }
                    }
                }
            }
        }
            return count;
    }
        

    public List<E> bfPath(E start, E end){
        Vertex<E> startV = vertices.get(start);
        Vertex<E> endV = vertices.get(end);
        LinkedList<Vertex<E>> queue = new LinkedList<>();
        Map<Vertex<E>,Vertex<E>> predecessors = new HashMap<>();
        queue.add(startV);
        predecessors.put(startV,null);
        while(!queue.isEmpty()){
            Vertex<E> v = queue.remove(0);
            if(v ==endV){
                return makePath(predecessors, endV);
            } else{
                Set<Vertex<E>> neighbors = v.getNeighbors();
                for(Vertex<E> neighbor : neighbors){
                    if(!predecessors.containsKey(neighbor)){
                        predecessors.put(neighbor,v);
                        queue.add(neighbor);
                    }
                } 
            }
        }

        return null;
    }
    private List<E> makePath(Map<Vertex <E>, Vertex <E>> predecessors,Vertex <E> endV ){
        if(predecessors.containsKey(endV)){
            LinkedList<E> path = new LinkedList<>();
            Vertex<E> current = endV;
            while(current!=null){
                path.add(0,current.getValue());
                Vertex<E> predecessor = predecessors.get(current);
                current = predecessor;
            }

            return path;
        }else{
            return null;
        }
    }
    private void visitDFS(Vertex<E> currV, Set<Vertex<E>> visited){
        // visits all nodes connect startV and adds to the visited set
        for(Vertex<E> nbrV : currV.getNeighbors()){
            if(!visited.contains(nbrV)){
                visited.add(nbrV);
                visitDFS(nbrV, visited);
            }
            
        }

    }

    @Override
    public boolean dfSearch(E start, E end) {
        Vertex<E> startV = vertices.get(start);
        Vertex<E> endV = vertices.get(end);
        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(startV);
        visitDFS(startV, visited);
        return visited.contains(endV);
    }
    @Override
    public List<E> dfPath(E start, E end) {
        Vertex<E> startV = vertices.get(start);
        Vertex<E> endV = vertices.get(end);
        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(startV);
        return makePathDFS(startV, endV, visited);
    }
    private List<E> makePathDFS(Vertex<E> currV, Vertex<E> endV, Set<Vertex<E>> visited) {
        if(currV == endV) {
            List<E> path = new LinkedList<>();
            path.add(endV.getValue());
            return path;
        }
        for(Vertex<E> nbrV : currV.getNeighbors()) {
            if(!visited.contains(nbrV)) {
                visited.add(nbrV);
                List<E> path = makePathDFS(nbrV, endV, visited);
                if(path != null) {
                    path.add(0, currV.getValue());
                    return path;
                }
            }
        }
        return null;
    }
}
