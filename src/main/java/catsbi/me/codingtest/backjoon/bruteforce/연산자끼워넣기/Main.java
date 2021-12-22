package catsbi.me.codingtest.backjoon.bruteforce.연산자끼워넣기;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14888
 */
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] operators;
    static int[] nums;
    static int max;
    static int min;

    public static void main(String[] args) {
        input();

        rec_func(1, nums[1]);
        sb.append(max).append(System.lineSeparator()).append(min);
        System.out.println(sb);
    }

    static void rec_func(int k, int value) {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int cand = 1; cand <= 4; cand++) {
            if (operators[cand] >= 1) {
                operators[cand]--;
                rec_func(k + 1, calculate(value, cand, nums[k + 1]));
                operators[cand]++;
            }
        }

    }

    private static int calculate(int value1, int operator, int value2) {
        if (operator == 1) {
            return value1 + value2;
        }
        if (operator == 2) {
            return value1 - value2;
        }
        if (operator == 3) {
            return value1 * value2;
        }
        return value1 / value2;
    }


    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }

        for (int i = 1; i <= 4; i++) {
            operators[i] = scan.nextInt();
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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
