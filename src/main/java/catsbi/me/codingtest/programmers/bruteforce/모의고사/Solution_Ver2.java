package catsbi.me.codingtest.programmers.bruteforce.모의고사;

import java.util.Arrays;
import java.util.List;

class Solution_Ver2 {
    private static final List<Student> students = Arrays.asList(
            new Student(1, new int[]{1, 2, 3, 4, 5}),
            new Student(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}),
            new Student(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}));

    public int[] solution(int[] answers) {
        int maxPoint = 0;

        for (Student student : students) {
            maxPoint = Math.max(student.matchesAnswer(answers), maxPoint);
        }

        final int finalMaxPoint = maxPoint;

        return students.stream()
                .filter(student -> student.getMatchPoint() == finalMaxPoint)
                .mapToInt(Student::getId)
                .sorted()
                .toArray();
    }

    private static class Student {
        private final int id;
        private final int[] pattern;
        private int matchPoint;

        public Student(int id, int[] pattern) {
            this.id = id;
            this.pattern = pattern;
            this.matchPoint = 0;
        }

        public int getId() {
            return id;
        }

        public int getMatchPoint() {
            return matchPoint;
        }

        public int matchesAnswer(int[] answers) {
            int count = 0;
            final int lastIndexByPattern = pattern.length;

            for (int answerIdx = 0, patternIdx = 0;
                 answerIdx < answers.length;
                 answerIdx++, patternIdx = (patternIdx + 1) % lastIndexByPattern) {

                if (answers[answerIdx] == pattern[patternIdx]) {
                    count++;
                }
            }

            this.matchPoint = count;
            return count;
        }
    }
}
