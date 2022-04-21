package graphs;

public class Edge<E> implements Comparable<Edge<E>> {
    private double weight;
    private WVertex<E> from;
    private WVertex<E> to;

    public Edge(WVertex<E> from, WVertex<E> to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public WVertex<E> getFrom() {
        return from;
    }

    public WVertex<E> getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge<E> o) {
        // sorted by weight in ascending order - for nearest neighbor search
        return this.weight <= o.weight ? -1 : 1; 
    }
}
