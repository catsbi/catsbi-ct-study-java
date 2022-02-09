package catsbi.me.codingtest.programmers.stackque.기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private static class Job {
        int id;
        int percent;
        int speed;
        boolean deployed;

        Job(int id, int percent, int speed) {
            this.id = id;
            this.percent = percent;
            this.speed = speed;
            this.deployed = false;
        }

        void deploy() {
            deployed = true;
        }

        boolean deployable() {
            return !deployed && percent >= 100;
        }

        void proceed() {
            if (percent < 100) {
                int remain = 100 - percent;
                if (remain <= speed) {
                    percent = 100;
                    return;
                }
                percent += speed;
            }
        }

        @Override
        public String toString() {
            return "[%d, %d, %d, %s]".formatted(id, percent, speed, deployed);
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Job> jobs = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int cursor = 0;

        for (int i = 0; i < progresses.length; i++) {
            jobs.add(new Job(i, progresses[i], speeds[i]));
        }

        while (!jobs.get(jobs.size() - 1).deployed) {
            proceedJobs(jobs);

            if (jobs.get(cursor).deployable()) {
                System.out.println("(%d, %s)".formatted(cursor, jobs));

                Integer count = countDeployableJobs(jobs, cursor);
                answer.add(count);

                cursor += count;
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private Integer countDeployableJobs(List<Job> jobs, int cursor) {
        for (int i = cursor, count = 0; i < jobs.size(); i++, count++) {
            Job job = jobs.get(i);
            if (!job.deployable()) {
                return count;
            }
            job.deploy();
        }

        return jobs.size() - cursor;
    }

    private void proceedJobs(List<Job> jobs) {
        jobs.forEach(Job::proceed);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] result1 = s.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(result1));

        int[] result2 = s.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        System.out.println(Arrays.toString(result2));

    }
}
