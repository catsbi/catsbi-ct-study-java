package catsbi.me.codingtest.backjoon.bruteforce.분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            if (calculate(i) == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    private static int calculate(int number) {
        int sum = number;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
