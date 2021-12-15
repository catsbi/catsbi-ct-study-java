package catsbi.me.algorithm.pathfinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DijkstraPathTest {
    private Map<String, List<Edge<String>>> graph = new HashMap<>();

    @BeforeEach
    void setUp() {
        graph.put("A", new ArrayList<>(Arrays.asList(new Edge<>(8, "B"), new Edge<>(1, "C"), new Edge<>(2, "D"))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new Edge<>(5, "B"), new Edge<>(2, "D"))));
        graph.put("D", new ArrayList<>(Arrays.asList(new Edge<>(3, "E"), new Edge<>(5, "F"))));
        graph.put("E", new ArrayList<>(Arrays.asList(new Edge<>(1, "F"))));
        graph.put("F", new ArrayList<>(Arrays.asList(new Edge<>(5, "A"))));
    }


    @Test
    void test() {
        final DijkstraPath pathFinder = new DijkstraPath();

        final Map<String, Integer> result = pathFinder.pathFind(graph, "A");

        System.out.println("result = " + result.toString());
    }

}
