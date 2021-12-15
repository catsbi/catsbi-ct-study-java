package catsbi.me.algorithm.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Kruskal {
    private final Map<String, String> parent = new HashMap<>();
    private final Map<String, Integer> rank = new HashMap<>();

    public String findRootNode(String node) {
        if (!Objects.equals(parent.get(node), node)) {
            parent.put(node, findRootNode(parent.get(node)));
        }

        return parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = findRootNode(nodeV);
        String root2 = findRootNode(nodeU);

        //union-by-rank 기법
        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {
            parent.put(root1, root2);
            if (Objects.equals(rank.get(root1), rank.get(root2))) {
                rank.put(root2, rank.get(root1) + 1);
            }
        }
    }

    public void makeSet(String node) {
        parent.put(node, node);
        rank.put(node, 0);
    }

    public List<Edge> kruskalFunc(List<String> vertices, List<Edge> edges) {
        List<Edge> mst = new ArrayList<>();
        Edge currentNode;

        //1. 초기화
        for (String vertex : vertices) {
            makeSet(vertex);
        }

        //2. 간선 weight 기반 정렬
        Collections.sort(edges);

        for (Edge edge : edges) {
            currentNode = edge;
            if (findRootNode(currentNode.getNodeV()) != findRootNode(currentNode.getNodeU())) {
                union(currentNode.getNodeV(), currentNode.getNodeU());
                mst.add(currentNode);
            }
        }

        return mst;
    }

}
