package catsbi.me.algorithm.pathfinder;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class DijkstraPath {

    /*public <T extends Comparable<T>> Map<T, Integer> pathFind(Map<T, List<Edge<T>>> graph, T start) {



        return null;
    }*/

    public <T extends Comparable<T>> Map<T, Integer> pathFind(Map<T, List<Edge<T>>> graph, T start) {

        Edge<T> curNode;
        Edge<T> adjacentNode;
        int currentDistance;
        int weight;
        int distance;
        T currentNode;
        T adjacent;
        List<Edge<T>> nodeList;

        Map<T, Integer> distances = initDistance(graph, start);

        Queue<Edge<T>> queue = new PriorityQueue<>();
        queue.add(new Edge<>(distances.get(start), start));

        while (!queue.isEmpty()) {
            curNode = queue.poll();

            currentDistance = curNode.distance;
            currentNode = curNode.vertex;

            if (distances.get(currentNode) < currentDistance) {
                continue;
            }
            nodeList = graph.get(currentNode);
            for (Edge<T> edge : nodeList) {
                adjacentNode = edge;
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;

                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    queue.add(new Edge<>(distance, adjacent));
                }
            }
        }

        return distances;
    }

    private <T extends Comparable<T>> Map<T, Integer> initDistance(Map<T, List<Edge<T>>> graph, T start) {
        final Map<T, Integer> result = graph.keySet().stream()
                .collect(Collectors.toMap(key -> key,
                        key -> Integer.MAX_VALUE,
                        Math::max));

        result.put(start, 0);
        return result;
    }
}
