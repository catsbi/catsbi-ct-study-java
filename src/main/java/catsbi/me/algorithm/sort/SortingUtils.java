package catsbi.me.algorithm.sort;

import java.util.Collections;
import java.util.List;

public class SortingUtils {
    private SortingUtils() {
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            boolean swap = false;

            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    Collections.swap(list, j, j + 1);
                    swap = true;
                }
            }

            if (!swap) {
                return;
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(List<T> list) {
        int targetIndex;

        for (int i = 0; i < list.size() - 1; i++) {
            targetIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(targetIndex).compareTo(list.get(j)) > 0) {
                    targetIndex = j;
                }
            }

            if (targetIndex != i) {
                Collections.swap(list, i, targetIndex);
            }
        }

    }
}
