package catsbi.me.codingtest.backjoon.search.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class Main {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static List<Integer> group;
    static int N, C;
    static String[] adj;
    static boolean[][] visit;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!visit[x][y] && adj[x].charAt(y) == '1') {
                    C = 0;
                    dfs(x, y);
                    group.add(C);
                }
            }
        }

        Collections.sort(group);

        sb.append(group.size()).append('\n');
        for (Integer it : group) {
            sb.append(it).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        C++;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N
                    || visit[nx][ny]
                    || adj[nx].charAt(ny) == '0') {
                continue;
            }
            dfs(nx, ny);
        }
    }

    public static void input() {
        N = fr.nextInt();
        adj = new String[N];
        visit = new boolean[N][N];
        group = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj[i] = fr.nextLine();
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
