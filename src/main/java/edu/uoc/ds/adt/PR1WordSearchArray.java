package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Set;
import edu.uoc.ds.adt.sequential.StackArrayImpl;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.adt.sequential.Stack;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PR1WordSearchArray {
    private final char[][] grid;
    private final int rows;
    private final int cols;

    public enum Direction {
        HORIZONTAL, VERTICAL
    }

    public static class Result {
        String word;
        int row;
        int col;
        Direction direction;

        public Result(String word, int row, int col, Direction direction) {
            this.word = word;
            this.row = row;
            this.col = col;
            this.direction = direction;
        }
    }

    public PR1WordSearchArray(String input) {
        var lines = input.split("\n");
        rows = lines.length;
        cols = lines[0].length();
        grid = IntStream.range(0, rows)
                .mapToObj(i -> lines[i].toCharArray())
                .toArray(char[][]::new);
    }

    public Stack<Result> search(Set<String> words) {
        Stack<Result> foundWords = new StackArrayImpl<Result>(100);
        Iterator<String> it = words.values();

        while (it.hasNext()) {
            String word = it.next();

            boolean found = this.horizontalSearch(word).findFirst().map(result -> {
                foundWords.push(result);
                return true;
            }).orElse(false);

            if (!found) {
                this.verticalSearch(word).findFirst().ifPresent(foundWords::push);
            }
        }

        return foundWords;
    }

    private Stream<Result> horizontalSearch(String word) {
        return IntStream.range(0, rows)
                .boxed()
                .flatMap(i -> IntStream.range(0, cols - word.length() + 1)
                        .filter(j -> foundHorizontalMatch(i, j, word))
                        .mapToObj(j -> {
                            System.out.println("Found horizontal match: " + word + " at (" + i + ", " + j + ")");
                            return new Result(word, i, j, Direction.HORIZONTAL);
                        })
                );
    }

    private Stream<Result> verticalSearch(String word) {
        return IntStream.range(0, rows - word.length() + 1)
                .boxed()
                .flatMap(i -> IntStream.range(0, cols)
                        .filter(j -> foundVerticalMatch(i, j, word))
                        .mapToObj(j -> {
                            System.out.println("Found vertical match: " + word + " at (" + i + ", " + j + ")");
                            return new Result(word, i, j, Direction.VERTICAL);
                        })
                );
    }

    private boolean foundHorizontalMatch(int row, int col, String word) {
        return IntStream.range(0, word.length())
                .allMatch(i -> grid[row][col + i] == word.charAt(i));
    }

    private boolean foundVerticalMatch(int row, int col, String word) {
        return IntStream.range(0, word.length())
                .allMatch(i -> grid[row + i][col] == word.charAt(i));
    }
}