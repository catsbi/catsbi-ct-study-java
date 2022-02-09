package catsbi.me.codingtest.programmers.stackque.기능개발;

import java.util.LinkedHashMap;
import java.util.Map;

public class SolutionV3 {
    public static final double COMPLETE_POINT = 100D;

    public int[] solution(int[] progresses, int[] speeds) {
        int prevCompleteDay = 0;

        Map<Integer, Integer> answer = new LinkedHashMap<>();

        for (int i = 0; i < progresses.length; i++) {
            int completeDay = (int) Math.ceil((COMPLETE_POINT - progresses[i]) / speeds[i]);
            prevCompleteDay = Math.max(prevCompleteDay, completeDay);

            answer.merge(prevCompleteDay, 1, (val, putVal) -> ++val);
        }

        return answer.values()
                .stream()
                .mapToInt(day-> day)
                .toArray();
    }
}
