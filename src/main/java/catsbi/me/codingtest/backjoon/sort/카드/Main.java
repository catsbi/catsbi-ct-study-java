package catsbi.me.codingtest.backjoon.sort.카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class Main {
    static FastReader fr = new FastReader();
    static int N, maxCount, curCount;
    static long maxNum;
    static long[] arr;

    public static void main(String[] args) {
        input();

        calculate();
    }

    private static void calculate() {
        Arrays.sort(arr);
        maxNum = arr[0];
        maxCount = 1;
        curCount = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i - 1]) {
                curCount++;
            } else {
                curCount = 1;
            }
            System.out.printf("%d, %d, %d\n", maxCount, curCount, maxNum);
            if (maxCount < curCount) {
                maxNum = arr[i];
                maxCount = curCount;
            }
        }

        System.out.println(maxNum);
    }

    public static void input() {
        N = fr.nextInt();
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = fr.nextLong();
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
            return Long.parseLong(next());
        }
    }
}
