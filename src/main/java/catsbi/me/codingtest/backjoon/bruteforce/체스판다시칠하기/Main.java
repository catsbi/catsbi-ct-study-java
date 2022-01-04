package catsbi.me.codingtest.backjoon.bruteforce.체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader fr = new FastReader();
    static int N, M;
    static int MIN = Integer.MAX_VALUE;
    static char[][] arr;
    static char[] BW = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
    static char[] WB = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
    static char[][] BW_BOARD = {BW, WB};
    static char[][] WB_BOARD = {WB, BW};

    public static void main(String[] args) {
        input();

        calculate();

        System.out.println(MIN);
    }

    private static void calculate() {
        int count;
        for (int n = 0; n <= N - 8; n++) {
            for (int m = 0; m <= M - 8; m++) {
                count = getNeedRepaintTiles(n, m);
                if (count < MIN) {
                    MIN = count;
                }
            }
        }
    }

    private static int getNeedRepaintTiles(int startY, int startX) {
        int bwCount = 0, wbCount = 0;

        for (int y = startY; y < startY + 8; y++) {
            for (int x = startX, i = 0; x < startX + 8; x++, i++) {
                if (arr[y][x] != BW_BOARD[(y - startY) % 2][x - startX]) {
                    bwCount++;
                    continue;
                }

                if (arr[y][x] != WB_BOARD[(y - startY) % 2][x - startX]) {
                    wbCount++;
                }
            }
        }

        return Math.min(MIN, Math.min(wbCount, bwCount));
    }

    private static void input() {
        N = fr.nextInt();
        M = fr.nextInt();
        arr = new char[N][M];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = fr.nextLine().toCharArray();
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
