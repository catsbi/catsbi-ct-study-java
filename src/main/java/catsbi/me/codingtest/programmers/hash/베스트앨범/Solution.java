package catsbi.me.codingtest.programmers.hash.베스트앨범;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Albums> genresMap = IntStream.range(0, genres.length)
                .mapToObj(idx -> new Album(idx, genres[idx], plays[idx]))
                .collect(Collectors.groupingBy(ab -> ab.genre, Collectors.toCollection(Albums::new)));

        return genresMap.values().stream()
                .sorted()
                .flatMap(list -> list.getBestTwoAlbums().stream())
                .mapToInt(ab-> ab.id)
                .toArray();
    }

    private static class Album implements Comparable<Album> {
        int id;
        String genre;
        int play;

        public Album(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Album o) {
            int compareResult = o.play - this.play;

            if (compareResult == 0) {
                return id - o.id;
            }

            return o.play - this.play;
        }

        @Override
        public String toString() {
            return "[%d, %s, %d]".formatted(id, genre, play);
        }
    }

    private static class Albums extends AbstractList<Album> implements Comparable<Albums> {
        List<Album> values = new ArrayList<>();

        List<Album> getBestTwoAlbums() {
            if (size() < 2) {
                return values;
            }
            Collections.sort(values);
            return values.subList(0, 2);
        }

        @Override
        public boolean add(Album album) {
            return values.add(album);
        }

        @Override
        public Album set(int index, Album element) {
            return values.set(index, element);
        }

        @Override
        public int compareTo(Albums o) {
            return o.totalPlays() - totalPlays();
        }

        private int totalPlays() {
            return values.stream().mapToInt(ab -> ab.play).sum();
        }

        @Override
        public Album get(int index) {
            return values.get(index);
        }

        @Override
        public int size() {
            return values.size();
        }
    }

    public static void main(String[] args) {
        int[] result1 = new Solution().solution(
                new String[]{"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});

        System.out.println(Arrays.toString(result1));

        int[] result2 = new Solution().solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500});

        System.out.println(Arrays.toString(result2));
    }
}
