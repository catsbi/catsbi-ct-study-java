package catsbi.me.codingtest.backjoon.bruteforce.부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader fr = new FastReader();
    static int N, S, ans;
    static int[] arr;

    public static void main(String[] args) {
        input();

        calculate(0, 0);

        // S가 0인 경우 아무 값도 안 더했을 경우의 수가 추가 되기에 -1 해줘야 한다.
        if (S == 0) {
            ans--;
        }

        System.out.println(ans);
    }

    private static void calculate(int position, int sum) {
        if (position == arr.length) {
            if (sum == S) {
                ans++;
            }
            return;
        }

        calculate(position + 1, arr[position] + sum);
        calculate(position + 1, sum);
    }

    private static void input() {
        N = fr.nextInt();
        S = fr.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
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
