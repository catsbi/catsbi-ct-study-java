package catsbi.me.codingtest.backjoon.sort.수열정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class Main_Ver2 {
    static FastReader fr = new FastReader();
    static int N;
    static int[] P;
    static Elm[] B;

    public static void main(String[] args) {
        input();

        pro();
    }

    private static void pro() {
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            P[B[i].idx] = i;
        }

        String result = Arrays.stream(P).mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }

    public static void input() {
        N = fr.nextInt();
        B = new Elm[N];
        P = new int[N];

        for (int i = 0; i < B.length; i++) {
            B[i] = new Elm(fr.nextInt(), i);
        }
    }

    private static class Elm implements Comparable<Elm> {
        int num, idx;

        public Elm(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        /**
         * Arrays.sort() 메서드는 Object를 기준으로는 Tim Sort로 정렬한다.
         * 즉, Stable(안정된) 정렬이기에 idx는 정렬 로직에 추가할 필요 없다.
         */
        @Override
        public int compareTo(Elm o) {
            return num - o.num;
        }

        /**
         * TODO
         * 정렬 조건
         * 1. num의 비내림차순
         * 2. num이 같으면 idx 오름차순
         */
        /*@Override
        public int compareTo(Elm o) {

            if (num != o.num) {
                return num - o.num;
            }
            return idx - o.idx;
        }*/
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
