package catsbi.me.codingtest.backjoon.sort.수열정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class Main {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] A, sortedA;


    public static void main(String[] args) {
        input();

        calculate();

        System.out.println(sb);
    }

    private static void calculate() {
        for (int j : A) {
            sb.append(findIndex(j)).append(" ");
        }
    }

    private static int findIndex(int num) {
        for (int i = 0; i < sortedA.length; i++) {
            if (sortedA[i] == num) {
                sortedA[i] = -1;
                return i;
            }
        }
        return -1;
    }

    public static void input() {
        N = fr.nextInt();
        A = new int[N];

        for (int i = 0; i < A.length; i++) {
            A[i] = fr.nextInt();
        }

        sortedA = A.clone();
        Arrays.sort(sortedA);
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
