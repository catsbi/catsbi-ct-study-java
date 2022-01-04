package catsbi.me.codingtest.programmers.bruteforce.모의고사;

import java.util.stream.IntStream;

class Solution {
    int max = Integer.MIN_VALUE;
    int[][] marks = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    int[] answer = new int[marks.length];

    public int[] solution(int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            calculate(answers, i);
        }

        return IntStream.range(1, 4)
                .filter(index -> answer[index - 1] == max)
                .sorted()
                .toArray();
    }

    private void calculate(int[] answers, int index) {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i][index % marks[i].length] == answers[index]) {
                answer[i]++;
                max = Math.max(max, answer[i]);
            }
        }
    }
}
