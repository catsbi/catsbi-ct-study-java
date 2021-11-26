package catsbi.me.algorithm.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SortingUtilsTest {
    private List<Integer> mixedList;

    @BeforeEach
    void setUp() {
        mixedList = Arrays.asList(3, 7, 2, 6, 22, 42, 13);
    }

    @Test
    void bubbleSorting() {
        SortingUtils.bubbleSort(mixedList);

        assertThat(mixedList).containsExactly(2, 3, 6, 7, 13, 22, 42);
    }

}
