package catsbi.me.codingtest.backjoon.search.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class Main {
    static FastReader fr = new FastReader();
    static int N, M, B, ans;
    static boolean[][] visit;
    static int[][] walls, blanks;
    static Queue<Integer> Q;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void pro() {
        dfs(1, 0);

        System.out.println(ans);
    }

    private static void dfs(int cnt, int selectedCnt) {
        if (selectedCnt == 3) {
            bfs();
            return;
        }
        if (cnt > B)return;

        walls[blanks[cnt][0]][blanks[cnt][1]] = 1;
        dfs(cnt + 1, selectedCnt + 1);

        walls[blanks[cnt][0]][blanks[cnt][1]] = 0;
        dfs(cnt + 1, selectedCnt);
    }

    private static void bfs() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visit[i][j] = false;
                if (walls[i][j] == 2) {
                    Q.offer(i);
                    Q.offer(j);
                    visit[i][j] = true;
                }
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (visit[nx][ny]) continue;
                if (walls[nx][ny] == 1) continue;
                visit[nx][ny] = true;
                Q.offer(nx);
                Q.offer(ny);
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visit[i][j] && walls[i][j] == 0) {
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }

    public static void input() {
        N = fr.nextInt();
        M = fr.nextInt();
        visit = new boolean[N + 1][M + 1];
        walls = new int[N + 1][M + 1];
        blanks = new int[N * M + 1][2];
        Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                walls[i][j] = fr.nextInt();
                if (walls[i][j] == 0) {
                    B++;
                    blanks[B][0] = i;
                    blanks[B][1] = j;
                }
            }
        }
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return parseInt(next());
        }

        long nextLong() {
            return parseLong(next());
        }

        double nextDouble() {
            return parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
