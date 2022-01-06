package catsbi.me.codingtest.backjoon.bruteforce.NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader fr = new FastReader();
    static int N, ans;
    static int[] arr;

    public static void main(String[] args) {
        input();

        calculate(1);

        System.out.println(ans);
    }

    private static void calculate(int position) {
        if (position == N + 1) {
            ans++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            boolean possible = true;
            for (int j = 1; j < position; j++) {
                if (attackable(position, i, j, arr[j])) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                arr[position] = i;
                calculate(position + 1);
                arr[position] = 0;
            }
        }

    }

    private static boolean attackable(int y1, int x1, int y2, int x2) {
        if (x1 == x2) {
            return true;
        }
        if (y1 - x1 == y2 - x2) {
            return true;
        }
        return y1 + x1 == y2 + x2;
    }

    private static void input() {
        N = fr.nextInt();
        arr = new int[N + 1];
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
