package catsbi.me.algorithm.pathfinder;

import java.util.Objects;

public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>>{

    public final int distance;
    public final T vertex;

    public Edge(int distance, T vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Edge o) {
        return distance - o.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Edge)) {
            return false;
        }
        Edge<?> edge = (Edge<?>) o;
        return distance == edge.distance && Objects.equals(vertex, edge.vertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, vertex);
    }

    @Override
    public String toString() {
        return String.format("vertex: %s, distance: %d", vertex.toString(), distance);
    }
}
