package catsbi.me.codingtest.backjoon.bruteforce.영화감독숌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int goal = Integer.parseInt(br.readLine());
        int count = 1;
        int result = 666;

        while (count < goal) {
            if (String.valueOf(++result).contains("666")) {
                count++;
            }
        }
        System.out.println(result);
    }

}
