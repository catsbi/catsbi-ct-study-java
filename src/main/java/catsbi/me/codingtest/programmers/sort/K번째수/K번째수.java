package catsbi.me.codingtest.programmers.sort.K번째수;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] sortedArray = Arrays.stream(array, commands[i][0] - 1, commands[i][1])
                    .sorted()
                    .toArray();

            answer[i] = sortedArray[commands[i][2]-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        final K번째수 solution = new K번째수();

        final int[] result = solution.solution(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});

        System.out.println("result = " + Arrays.toString(result));
    }
}
