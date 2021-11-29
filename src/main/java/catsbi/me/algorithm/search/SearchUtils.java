package catsbi.me.algorithm.search;

import java.util.List;

public class SearchUtils {

    public static <T> int sequentialSearch(List<T> list, T source) {
        for (int i = 0; i < list.size(); i++) {
            if (source.equals(list.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> int binarySearch(List<T> list, T source) {
        if (list.size() == 1 && list.get(0).equals(source)) {
            return 0;
        }
        if (list.isEmpty() || list.size() == 1 && !list.get(0).equals(source)) {
            return -1;
        }
        return binarySearch(list, source, 0, list.size());
    }

    private static <T extends Comparable<T>> int binarySearch(List<T> list, T source, int low, int high) {
        if (low > high) {
            return -1;
        }
        int medium = (low + high) / 2;
        final T target = list.get(medium);

        if (source.equals(target)) {
            return medium;
        }
        if (source.compareTo(target) < 0) {
            return binarySearch(list, source, low, medium - 1);
        }
        return binarySearch(list, source, medium + 1, high);
    }
}
