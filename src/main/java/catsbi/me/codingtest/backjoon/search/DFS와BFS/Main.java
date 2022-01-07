package catsbi.me.codingtest.backjoon.search.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class Main {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static boolean[] visit;
    static List<Integer>[] adj;

    public static void main(String[] args) {
        input();

        pro();
    }

    private static void pro() {
        dfs(V);
        sb.append("\n");
        Arrays.fill(visit, false);
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');

        for (int y : adj[x]) {
            if (!visit[y]) {
                dfs(y);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(' ');

            for (int y : adj[x]) {
                if (!visit[y]) {
                    visit[y] = true;
                    q.offer(y);
                }
            }
        }

    }

    public static void input() {
        N = fr.nextInt(); //정점의 갯수
        M = fr.nextInt(); //간선의 갯수
        V = fr.nextInt(); //시작 정점
        adj = new ArrayList[N+1];
        visit = new boolean[N+1];

        //각 정점에 연결된 간선을 담을 동적 배열 초기화
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        //정점 별 연결 정점(간선) 설정
        for (int i = 0; i < M; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }

        //정점 별 간선 리스트 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
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
    }
}
