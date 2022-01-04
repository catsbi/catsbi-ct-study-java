package catsbi.me.codingtest.backjoon.bruteforce.블랙잭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader fr = new FastReader();
    static int N, M, SUM, MAX = Integer.MIN_VALUE;
    static int arr[], used[], selected[];

    public static void main(String[] args) {
        input();

        calculate(0);

        System.out.println(MAX);
    }

    private static void calculate(int position) {
        SUM = getSum();

        if (SUM >= M && position < selected.length) {
            return;
        }

        if (position == selected.length) {
            if (SUM <= M) {
                MAX = Math.max(MAX, SUM);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            selected[position] = arr[i];

            calculate(position + 1);

            used[i] = 0;
            selected[position] = 0;
        }

    }

    private static int getSum() {
        return Arrays.stream(selected).sum();
    }

    private static void input() {
        N = fr.nextInt();
        M = fr.nextInt();

        arr = new int[N];
        used = new int[arr.length];
        selected = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = fr.nextInt();
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

