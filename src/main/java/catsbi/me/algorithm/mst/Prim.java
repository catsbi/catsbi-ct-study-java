package catsbi.me.algorithm.mst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prim {

    public List<Edge> primFunc(String start, List<Edge> edges) {
        List<String> connectedNodes = new ArrayList<>();
        List<Edge> mst = new ArrayList<>();

        Map<String, List<Edge>> adjacentEdges = new HashMap<>();
        Edge currentNode, poppedEdge;
        List<Edge> currentNodeList, candidateEdgeList, adjacentEdgeNodes;

        for (Edge edge : edges) {
            currentNode = edge;
            if (!adjacentEdges.containsKey(currentNode.node1)) {
                adjacentEdges.put(currentNode.node1, new ArrayList<>());
            }
            if (!adjacentEdges.containsKey(currentNode.node2)) {
                adjacentEdges.put(currentNode.node2, new ArrayList<>());
            }

        }

        for (Edge edge : edges) {
            currentNode = edge;
            currentNodeList = adjacentEdges.get(currentNode.node1);
            currentNodeList.add(new Edge(currentNode.weight, currentNode.node1, currentNode.node2));

            currentNodeList = adjacentEdges.get(currentNode.node2);
            currentNodeList.add(new Edge(currentNode.weight, currentNode.node2, currentNode.node1));
        }

        connectedNodes.add(start);
        candidateEdgeList = adjacentEdges.getOrDefault(start, new ArrayList<>());
        Queue<Edge> queue = new PriorityQueue<>(candidateEdgeList);

        while (!queue.isEmpty()) {
            poppedEdge = queue.poll();
            if (!connectedNodes.contains(poppedEdge.node2)) {
                //해당 edge를 mst 추가
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));
                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<>());

                for (Edge adjacentEdgeNode : adjacentEdgeNodes) {
                    if (!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        queue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;

    }

    public static class Edge implements Comparable<Edge>{
        private final int weight;
        private final String node1;
        private final String node2;

        public Edge(int weight, String node1, String node2) {
            this.weight = weight;
            this.node1 = node1;
            this.node2 = node2;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", node1='" + node1 + '\'' +
                    ", node2='" + node2 + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}
