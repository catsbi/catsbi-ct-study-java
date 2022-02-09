package catsbi.me.codingtest.backjoon.search.미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class Main {
    static FastReader fr = new FastReader();
    static int N, M;
    static int[][] dist;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static String[] arr;


    public static void main(String[] args) {
        input();
        pro();
    }

    public static void pro() {
        bfs(0, 0);

        System.out.println(dist[N-1][M-1]);
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer> Q = new LinkedList<>();
        dist[startX][startY] = 1;

        Q.offer(startX);
        Q.offer(startY);

        while (!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (dist[nx][ny] > 0) continue;
                if (arr[nx].charAt(ny) == '0') continue;
                dist[nx][ny] = dist[x][y] + 1;
                Q.offer(nx);
                Q.offer(ny);
            }
        }

    }

    public static void input() {
        N = fr.nextInt();
        M = fr.nextInt();
        dist = new int[N][M];
        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = fr.nextLine();
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
