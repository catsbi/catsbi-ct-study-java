package catsbi.me.codingtest.programmers.sort.hindex;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class Solution {
    /**
     * 재귀함수를 이용한 풀이 방법
     */
    public int solution(int[] citations) {
        Arrays.sort(citations);
        return recSolution(citations, citations.length - 1, 0);
    }

    private int recSolution(int[] citations, int index, int h) {
        if (index < 0 || citations.length - index > citations[index]) {
            return h;
        }

        return recSolution(citations, index - 1, h + 1);
    }

    public static void main(String[] args) {
        final int result = new Solution().solution(new int[]{3, 0, 6, 1, 5});
        System.out.println("result = " + result);
    }

    /**
     * 반복문을 이용한 풀이 방법
     */
    /*public int solution(int[] citations) {
        int n = citations.length, h = 0;
        Arrays.sort(citations);

        for (int i = n - 1; i >= 0; i--) {
            if ((n - i) > citations[i]) {
                return h;
            }
            h++;
        }
        return h;
    }*/
}
