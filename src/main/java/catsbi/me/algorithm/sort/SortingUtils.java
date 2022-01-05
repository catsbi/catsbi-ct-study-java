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


    public static <T extends Comparable<T>> List<T> quickSort(List<T> list) {
        if (list.size() <= 1) {
            return list;
        }

        final T pivot = list.get(0);
        final List<T> leftArr = new ArrayList<>();
        final List<T> rightArr = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(pivot) > 0) {
                rightArr.add(list.get(i));
                continue;
            }
            leftArr.add(list.get(i));
        }

        List<T> mergedArr = new ArrayList<>(quickSort(leftArr));
        mergedArr.add(pivot);
        mergedArr.addAll(quickSort(rightArr));

        return mergedArr;
    }

    /**
     * primitive middle pivot quick sort
     */
    public static void middleQuickSort(int[] nums) {
        middleQuickSort(nums, 0, nums.length - 1);
    }

    private static void middleQuickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(nums, low, high);

        middleQuickSort(nums, low, pivot);
        middleQuickSort(nums, pivot + 1, high);
    }

    private static int partition(int[] nums, int left, int right) {
        int low = left;
        int high = right;
        int pivot = nums[(left + right) / 2];

        while (low < high) {
            while (nums[low] < pivot) {
                low++;
            }

            while (nums[high] > pivot && low <= high) {
                high--;
            }

            swap(nums, low, high);
        }

        return high;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
