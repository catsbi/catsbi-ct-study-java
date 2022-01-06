package catsbi.me.codingtest.backjoon.sort.국영수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Student[] arr;

    public static void main(String[] args) {
        input();

        Arrays.sort(arr);

        for (Student student : arr) {
            sb.append(student.name).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    public static void input() {
        N = fr.nextInt();
        arr = new Student[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Student(fr.next(), fr.nextInt(), fr.nextInt(), fr.nextInt());
        }
    }

    private static class Student implements Comparable<Student> {
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (kor != o.kor) {
                return o.kor - kor;
            }

            if (eng != o.eng) {
                return eng - o.eng;
            }

            if (math != o.math) {
                return o.math - math;
            }

            return name.compareTo(o.name);
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
