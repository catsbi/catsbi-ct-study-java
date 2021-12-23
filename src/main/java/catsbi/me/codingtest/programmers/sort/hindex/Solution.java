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

    private int recSolution(int[] citations, int h, int answer) {
        if (h < 0 || citations.length - h >= citations[h]) {
            return answer;
        }

        return recSolution(citations, h - 1, answer + 1);
    }

    /**
     * 반복문을 이용한 풀이 방법
     */
    /*public int solution(int[] citations) {
        int n = citations.length, answer = 0;
        Arrays.sort(citations);

        for (int h = n - 1; h >= 0; h--) {
            if ((n - h) >= citations[h]) {
                return answer;
            }
            answer++;
        }
        return answer;
    }*/
}
