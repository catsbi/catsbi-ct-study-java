package catsbi.me.codingtest.backjoon.bruteforce.덩치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] arr;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < arr.length; i++) {
             sb.append(calculate(arr[i], i)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static int calculate(int[] info, int index) {
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (index == i) {
                continue;
            }

            if (arr[i][0] > info[0] && arr[i][1] > info[1]) {
                count++;
            }
        }

        return count;
    }

    private static void input() {
        N = fr.nextInt();
        arr = new int[N][2];
        rank = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i][0] = fr.nextInt();
            arr[i][1] = fr.nextInt();
        }
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
            return Integer.parseInt(next());
        }
    }
}
