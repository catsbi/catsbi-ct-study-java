package catsbi.me.codingtest.backjoon.search.물통;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.util.stream.Collectors.joining;

public class Main {
    static FastReader fr = new FastReader();
    static boolean[][][] visit;
    static int[] limit;
    static Set<Integer> answer;

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void pro() {
        bfs(0, 0, limit[2]);

        String result = answer.stream().sorted()
                .map(String::valueOf)
                .collect(joining(" "));

        System.out.println(result);
    }

    private static void bfs(int a, int b, int c) {
        Queue<State> Q = new LinkedList<>();
        visit[a][b][c] = true;
        Q.offer(State.of(a, b, c));

        while (!Q.isEmpty()) {
            State st = Q.poll();
            if (st.c[0] == 0) {
                answer.add(st.c[2]);
            }

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from != to) {
                        State next = st.move(from, to, limit);
                        if (!visit[next.c[0]][next.c[1]][next.c[2]]) {
                            visit[next.c[0]][next.c[1]][next.c[2]] = true;
                            Q.offer(next);
                        }
                    }
                }
            }

        }
    }

    public static void input() {
        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = fr.nextInt();
        }
        answer = new HashSet<>();
        visit = new boolean[limit[0]+1][limit[1]+1][limit[2]+1];
    }

    private static class State {
        int[] c;

        State(int[] c) {
            this.c = c;
        }

        static State of(int a, int b, int c) {
            return new State(new int[]{a, b, c});
        }

        public State move(int from, int to, int[] limit) {
            int[] newC = c.clone();
            if (limit[to] >= newC[from] + newC[to]) {
                newC[to] += newC[from];
                newC[from] = 0;
            } else {
                newC[from] -= limit[to] - newC[to];
                newC[to] = limit[to];
            }
            return new State(newC);
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
