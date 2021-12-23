package catsbi.me.codingtest.programmers.sort.가장큰수;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class Solution {
    public String solution(int[] numbers) {
        List<Integer> numbersArr = new ArrayList<>();
        int zeroCount = 0;
        StringBuilder sb = new StringBuilder();

        for (int number : numbers) {
            if (number == 0) {
                zeroCount++;
            }
            numbersArr.add(number);
        }

        if (zeroCount == numbers.length) {
            return "0";
        }

        List<Integer> sortedArr = quickSort(numbersArr);

        for (Integer value : sortedArr) {
            sb.append(value);
        }

        return sb.toString();
    }

    private List<Integer> quickSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        Integer pivot = list.get(0);
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            Integer value = list.get(i);
            if (isGrateThan(value, pivot)) {
                rightArr.add(value);
                continue;
            }
            leftArr.add(value);
        }


        List<Integer> mergedArr = new ArrayList<>(quickSort(leftArr));
        mergedArr.add(pivot);
        mergedArr.addAll(quickSort(rightArr));

        return mergedArr;
    }

    private boolean isGrateThan(Integer source, Integer target) {
        String value1 = "" + source + target;
        String value2 = "" + target + source;

        return value1.compareTo(value2) < 0;
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();

        final String result = solution.solution(new int[]{1, 10, 100, 1000});
        System.out.println("result = " + result);
    }
}
