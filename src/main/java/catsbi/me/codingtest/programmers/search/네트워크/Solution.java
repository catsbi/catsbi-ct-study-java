package catsbi.me.codingtest.programmers.search.네트워크;

class Solution {
    int answer;
    boolean[] visit;
    int[][] C;

    public int solution(int n, int[][] computers) {
        answer = 0;
        visit = new boolean[n];
        C = computers;

        for (int i = 0; i < C.length; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int index) {
        visit[index] = true;

        for (int i = 0; i < C[index].length; i++) {
            if (index == i || visit[i] || C[index][i] == 0) continue;
            dfs(i);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        final int result = s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println(result);
    }
}
