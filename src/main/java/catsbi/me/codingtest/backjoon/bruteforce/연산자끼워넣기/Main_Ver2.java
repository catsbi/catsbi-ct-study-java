package catsbi.me.codingtest.backjoon.bruteforce.연산자끼워넣기;

import catsbi.me.codingtest.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Ver2 {
    static FastReader fr = new FastReader();
    static int[] arr;
    static int[] selected;
    static int[] ops = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        input();

        calculate(0);

        System.out.printf("%d\n%d\n", MAX, MIN);

    }

    private static void calculate(int position) {
        if (position == selected.length) {
            int computed = compute();
            MAX = Math.max(MAX, computed);
            MIN = Math.min(MIN, computed);
            return;
        }

        for (int i = 0; i < ops.length; i++) {
            if (ops[i] == 0) {
                continue;
            }
            selected[position] = i;
            ops[i]--;
            calculate(position + 1);
            selected[position] = -1;
            ops[i]++;

        }

    }

    private static int compute() {
        int result = arr[0];

        for (int i = 0; i < selected.length; i++) {
            switch (selected[i]) {
                case 0:
                    result += arr[i + 1];
                    break;
                case 1:
                    result -= arr[i + 1];
                    break;
                case 2:
                    result *= arr[i + 1];
                    break;
                default:
                    result /= arr[i + 1];
                    break;
            }
        }

        return result;
    }

    private static void input() {
        arr = new int[fr.nextInt()];
        selected = new int[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = fr.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            ops[i] = fr.nextInt();
        }
        Arrays.fill(selected, -1);
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
