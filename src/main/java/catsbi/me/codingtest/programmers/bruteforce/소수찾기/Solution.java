package catsbi.me.codingtest.programmers.bruteforce.소수찾기;

import java.util.HashSet;
import java.util.Set;

class Solution {
    StringBuilder sb = new StringBuilder();
    Set<Integer> set;
    String[] strings;
    String[] result;
    int[] used;

    public int solution(String numbers) {
        strings = numbers.split("");
        used = new int[strings.length];
        set = new HashSet<>();

        for (int i = 1; i <= strings.length; i++) {
            result = new String[i];
            calculate(0);
        }

        return set.size();
    }

    private void calculate(int position) {
        if (position == result.length) {
            int resultNum = getResultNumber();
            if (isPrime(resultNum)) {
                set.add(resultNum);
            }
            return;
        }

        for (int cand = 0; cand < strings.length; cand++) {
            if (used[cand] == 1) {
                continue;
            }
            used[cand] = 1;
            result[position] = strings[cand];
            calculate(position + 1);
            used[cand] = 0;
        }
    }

    private int getResultNumber() {
        sb.setLength(0);
        for (String str : result) {
            sb.append(str);
        }
        return Integer.parseInt(sb.toString());
    }


    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        final Solution s = new Solution();
        final int result = s.solution("17");
        System.out.println("result: " + result + " isTrue: " + (result == 3));

        final int result2 = s.solution("011");
        System.out.println("result: " + result2 + " isTrue: " + (result2 == 2));

    }
}
