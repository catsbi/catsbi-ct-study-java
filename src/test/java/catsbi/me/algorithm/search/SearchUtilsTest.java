package catsbi.me.algorithm.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SearchUtilsTest {
    private static final Random random = new Random();
    private List<Integer> mixedList;
    private List<Integer> sortedList;

    @BeforeEach
    void setUp() {
        mixedList = Arrays.asList(3, 7, 2, 6, 22, 42, 13);

        sortedList = IntStream.range(1, 10)
                .map(i-> random.nextInt(10))
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }

    @RepeatedTest(50)
    void binarySearch() {
        final Integer targetNumber = sortedList.get(random.nextInt(9));

        final int index = SearchUtils.binarySearch(sortedList, targetNumber);

        System.out.println("sortedList = " + sortedList);
        System.out.println("index = " + index);
        System.out.println("result = " + sortedList.get(index));
        assertThat(sortedList.get(index)).isEqualTo(targetNumber);
    }

    /**
     * 테스트에 사용하는 데이터 트리 구조는 다음과 같다.
     *
     *          A
     *        /   \
     *      /      \
     *    B        C
     *   /       / ⎮ \
     *  D       G  H  I
     * ⎮ \            ⎮
     * E  F           J
     */
    @ParameterizedTest
    @MethodSource("provideSetGraph")
    void bfs(Map<String, List<String>> graph) {
        final List<String> visitRoot = SearchUtils.bfsFunc(graph, "A");

        assertThat(visitRoot).containsExactly("A", "B", "C", "D", "G", "H", "I", "E", "F", "J");
    }

    @ParameterizedTest
    @MethodSource("provideSetGraph")
    void dfs(Map<String, List<String>> graph) {
        final List<String> visitRoot = SearchUtils.dfsFunc(graph, "A");

        System.out.println("visitRoot = " + visitRoot);
        assertThat(visitRoot).containsExactly("A", "C", "I", "J", "H", "G", "B", "D", "F", "E");

    }

    @ParameterizedTest
    @MethodSource("provideSetGraph")
    void recursiveDfs(Map<String, List<String>> graph) {
        final List<String> visitRoot = SearchUtils.recursiveDFSFunc(graph, "A");

        System.out.println("visitRoot = " + visitRoot);
        assertThat(visitRoot).containsExactly("A", "C", "I", "J", "H", "G", "B", "D", "F", "E");

    }



    public static Stream<Arguments> provideSetGraph() {
        HashMap<String, List<String>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<>(List.of("D")));
        graph.put("F", new ArrayList<>(List.of("D")));
        graph.put("G", new ArrayList<>(List.of("C")));
        graph.put("H", new ArrayList<>(List.of("C")));
        graph.put("I", new ArrayList<>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<>(List.of("I")));

        return Stream.of(
                Arguments.of(graph)
        );
    }

}
