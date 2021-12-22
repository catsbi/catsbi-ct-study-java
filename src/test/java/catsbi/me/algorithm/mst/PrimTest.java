package catsbi.me.algorithm.mst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PrimTest {
    private ArrayList<Prim.Edge> myedges;
    private Map<String, Map<String, Integer>> mygraph;


    @BeforeEach
    void setUp() {
        myedges = new ArrayList<>();
        myedges.add(new Prim.Edge(7, "A", "B"));
        myedges.add(new Prim.Edge(5, "A", "D"));
        myedges.add(new Prim.Edge(8, "B", "C"));
        myedges.add(new Prim.Edge(9, "B", "D"));
        myedges.add(new Prim.Edge(7, "D", "E"));
        myedges.add(new Prim.Edge(5, "C", "E"));
        myedges.add(new Prim.Edge(7, "B", "E"));
        myedges.add(new Prim.Edge(6, "D", "F"));
        myedges.add(new Prim.Edge(8, "E", "F"));
        myedges.add(new Prim.Edge(9, "E", "G"));
        myedges.add(new Prim.Edge(11, "F", "G"));

        mygraph = new HashMap<>();

        HashMap<String, Integer> edges;
        edges = new HashMap<>();
        edges.put("B", 7);
        edges.put("D", 5);
        mygraph.put("A", edges);

        edges = new HashMap<>();
        edges.put("A", 7);
        edges.put("D", 9);
        edges.put("C", 8);
        edges.put("E", 7);
        mygraph.put("B", edges);

        edges = new HashMap<>();
        edges.put("B", 8);
        edges.put("E", 5);
        mygraph.put("C", edges);

        edges = new HashMap<>();
        edges.put("A", 5);
        edges.put("B", 9);
        edges.put("E", 7);
        edges.put("F", 6);
        mygraph.put("D", edges);

        edges = new HashMap<>();
        edges.put("B", 7);
        edges.put("C", 5);
        edges.put("D", 7);
        edges.put("F", 8);
        edges.put("G", 9);
        mygraph.put("E", edges);

        edges = new HashMap<>();
        edges.put("D", 6);
        edges.put("E", 8);
        edges.put("G", 11);
        mygraph.put("F", edges);

        edges = new HashMap<>();
        edges.put("E", 9);
        edges.put("F", 11);
        mygraph.put("G", edges);
    }


    @Test
    void primTest() {
        final Prim prim = new Prim();
        final List<Prim.Edge> result = prim.primFunc("A", myedges);

        System.out.println("result = " + result);
    }

    @Test
    void primVer2Test() {
        PrimVer2 prim = new PrimVer2();
        List<Path> result = prim.primFunc(mygraph, "A");

        System.out.println("result = " + result);
    }

    @Test
    void test() {
        List<String> arr1 = List.of("a","b","c");
        List<String> arr2 = List.of("d","e","f");

        final List<String> collect = Stream.of(arr1, arr2)
                .flatMap(Collection::stream)
                .map(str -> str + "po")
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);
    }

}
