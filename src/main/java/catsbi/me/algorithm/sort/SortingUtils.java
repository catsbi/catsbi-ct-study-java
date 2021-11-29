package catsbi.me.algorithm.sort;

import java.util.ArrayList;
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

    public static <T extends Comparable<T>> void insertionSort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j > 0 && list.get(j).compareTo(list.get(j - 1)) < 0; j--) {
                Collections.swap(list, j, j - 1);
            }
        }
    }


    public static <T extends Comparable<T>> List<T> mergeSort(List<T> list) {
        if (list.size() == 1) {
            return list;
        }
        final int medium = list.size() / 2;

        List<T> left = mergeSort(new ArrayList<>(list.subList(0, medium)));
        List<T> right = mergeSort(new ArrayList<>(list.subList(medium, list.size())));

        return merge(left, right);
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> leftArr, List<T> rightArr) {
        List<T> result = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        while (leftPoint < leftArr.size() && rightPoint < rightArr.size()) {
            if (leftArr.get(leftPoint).compareTo(rightArr.get(rightPoint)) < 0) {
                result.add(leftArr.get(leftPoint));
                leftPoint++;
                continue;
            }
            result.add(rightArr.get(rightPoint));
            rightPoint++;
        }

        while (leftArr.size() > leftPoint) {
            result.add(leftArr.get(leftPoint++));
        }

        while (rightArr.size() > rightPoint) {
            result.add(rightArr.get(rightPoint++));
        }

        return result;
    }


    public static <T extends Comparable<T>> void quickSort(List<T> list) {

    }


}
