package catsbi.me.algorithm.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

}
