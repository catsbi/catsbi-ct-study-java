package catsbi.me.algorithm.math;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 에라토스테네스의 체를 이용한 소수 구하기 알고리즘
 */

public class PrimeNumberCalculator {
    static int[] arr;

    public static void printCalculate(int length) {
        fill(length);
        filtering();
        print();
    }

    private static void fill(int length) {
        arr = new int[length + 1];
        for (int i = 2; i <= length; i++) {
            arr[i] = i;
        }
    }

    private static void filtering() {
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0) {
                for (int j = 2 * i; j < arr.length; j += i) {
                    arr[j] = 0;
                }
            }
        }
    }

    private static void print() {
        String result = Arrays.stream(arr)
                .filter(num -> num != 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.printf("[%s]", result);
    }

}
