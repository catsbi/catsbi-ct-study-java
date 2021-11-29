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

    @Test
    void selectionSorting() {
        SortingUtils.selectionSort(mixedList);

        assertThat(mixedList).containsExactly(2, 3, 6, 7, 13, 22, 42);
    }

    @Test
    void insertionSorting() {
        SortingUtils.insertionSort(mixedList);

        assertThat(mixedList).containsExactly(2, 3, 6, 7, 13, 22, 42);
    }

    @Test
    void mergeSorting() {
        final List<Integer> result = SortingUtils.mergeSort(mixedList);

        System.out.println("merge sort result = " + result);
        assertThat(result).containsExactly(2, 3, 6, 7, 13, 22, 42);

    }

    @Test
    void quickSorting() {
        final List<Integer> result = SortingUtils.quickSort(mixedList);

        assertThat(result).containsExactly(2, 3, 6, 7, 13, 22, 42);

    }

}
