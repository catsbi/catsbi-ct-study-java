package catsbi.me.algorithm.mst;

public class Edge implements Comparable<Edge>{

    private int weight;
    private String nodeV;
    private String nodeU;

    public Edge(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", nodeV='" + nodeV + '\'' +
                ", nodeU='" + nodeU + '\'' +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getNodeV() {
        return nodeV;
    }

    public void setNodeV(String nodeV) {
        this.nodeV = nodeV;
    }

    public String getNodeU() {
        return nodeU;
    }

    public void setNodeU(String nodeU) {
        this.nodeU = nodeU;
    }
}
