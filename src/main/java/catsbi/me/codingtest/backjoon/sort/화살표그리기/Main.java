package catsbi.me.codingtest.backjoon.sort.화살표그리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    static FastReader fr = new FastReader();
    static int N, D;
    static Map<Integer, List<Point>> P;


    public static void main(String[] args) {
        input();

        calculate();
    }

    private static void calculate() {
        int left, right;
        for (List<Point> points : P.values()) {
            Collections.sort(points);
            int distance = 0;

            for (int i = 0; i < points.size(); i++) {
                left = toLeft(points, i);
                right = toRight(points, i);
                distance += Math.min(left, right);
            }
            D += distance;
        }

        System.out.println(D);
    }

    private static int toRight(List<Point> points, int index) {
        if (index + 1 == points.size()) {
            return Integer.MAX_VALUE;
        }
        return points.get(index + 1).position - points.get(index).position;
    }

    private static int toLeft(List<Point> points, int index) {
        if (index == 0) {
            return Integer.MAX_VALUE;
        }
        return points.get(index).position - points.get(index - 1).position;
    }

    public static void input() {
        D = 0;
        N = fr.nextInt();
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            pointList.add(new Point(fr.nextInt(), fr.nextInt()));
        }

        P = pointList.stream()
                .collect(groupingBy(p -> p.color));
    }

    private static class Point implements Comparable<Point> {
        int color;
        int position;

        public Point(int position, int color) {
            this.position = position;
            this.color = color;
        }

        @Override
        public int compareTo(Point o) {
            return position - o.position;
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
    }
}
