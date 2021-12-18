package catsbi.me.algorithm.mst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimVer2 {
    public static class Edge implements Comparable<Edge> {
        private String node;
        private int weight;

        public Edge(String node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "node='" + node + '\'' +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    public List<Path> primFunc(Map<String, Map<String, Integer>> graph, String startNode) {
        List<Path> mst = new ArrayList<>();
        Queue<Edge> keys = new PriorityQueue<>();
        Map<String, Edge> keyObjects = new HashMap<>();
        Map<String, String> mstPath = new HashMap<>();
        Map<String, Integer> linkedEdges;
        Edge edgeObject, poppedEdge, linkedEdge;
        int totalWeight = 0;

        for (String key : graph.keySet()) {
            if (key.equals(startNode)) {
                edgeObject = new Edge(key, 0);
                mstPath.put(key, key);
            } else {
                edgeObject = new Edge(key, Integer.MAX_VALUE);
                mstPath.put(key, null);
            }
            keys.add(edgeObject);
            keyObjects.put(key, edgeObject);
        }

        while (!keys.isEmpty()) {
            poppedEdge = keys.poll();
            keyObjects.remove(poppedEdge.node);

            mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));
            totalWeight += poppedEdge.weight;

            linkedEdges = graph.get(poppedEdge.node);
            for (String adjacent : linkedEdges.keySet()) {
                if (keyObjects.containsKey(adjacent)) {
                    linkedEdge = keyObjects.get(adjacent);

                    if (linkedEdges.get(adjacent) < linkedEdge.weight) {
                        linkedEdge.weight = linkedEdges.get(adjacent);
                        mstPath.put(adjacent, poppedEdge.node);

                        keys.remove(linkedEdge);
                        keys.add(linkedEdge);
                    }
                }
            }
        }
        System.out.println("totalWeight = " + totalWeight);
        return mst;
    }


}
