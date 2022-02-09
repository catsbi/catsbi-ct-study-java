package catsbi.me.codingtest.programmers.stackque.기능개발;

import java.util.Arrays;

public class SolutionV2 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        int cursor = 0;
        int answerCount = 0;

        while (cursor < progresses.length) {
            int completionDay = getCompletionDay(progresses, speeds, cursor);
            for (int i = cursor; i < progresses.length; i++) {
                if (completionDay < getCompletionDay(progresses, speeds, i)) {
                    break;
                }
                answer[answerCount]++;
            }
            cursor += answer[answerCount];
            answerCount++;
        }
        return Arrays.stream(answer).filter(i -> i > 0).toArray();
    }

    private int getCompletionDay(int[] progresses, int[] speeds, int cursor) {
        return (int) Math.ceil((100D - progresses[cursor]) / speeds[cursor]);
    }

    public static void main(String[] args) {
        SolutionV2 s = new SolutionV2();

        int[] result1 = s.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(result1));

        int[] result2 = s.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        System.out.println(Arrays.toString(result2));

    }
}
