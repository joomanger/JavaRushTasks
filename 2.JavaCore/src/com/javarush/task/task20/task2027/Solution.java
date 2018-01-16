package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static Word findWord(int[][] crossword, String word, int x, int y, String direct) {
        int size = word.toCharArray().length;

        // System.out.println(size);
        char[] newWord = new char[size];

        int idx = 0;
        if (direct.equals("RIGHT")) {
            try {
                for (int yy = y; yy <= y + size - 1; yy++) {
                    // System.out.println((char) crossword[x][yy]);
                    newWord[idx++] = (char) crossword[x][yy];
                }
                if (Arrays.equals(word.toCharArray(), newWord)) {
                    System.out.println("RIGHT YES");
                    Word w = new Word(word);
                    w.setStartPoint(y, x);
                    w.setEndPoint(y + size - 1, x);
                    //System.out.println(w);
                    return w;

                } else {
                    return findWord(crossword, word, x, y, "DOWN");
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                return findWord(crossword, word, x, y, "DOWN");
            }
        }

        idx = 0;
        if (direct.equals("DOWN")) {
            try {
                for (int xx = x; xx <= x + size - 1; xx++) {
                    newWord[idx++] = (char) crossword[xx][y];
                }
                if (Arrays.equals(word.toCharArray(), newWord)) {
                    System.out.println("DOWN YES");
                    Word w = new Word(word);
                    w.setStartPoint(y, x);
                    w.setEndPoint(y, x + size - 1);
                    return w;
                } else {
                    return findWord(crossword, word, x, y, "LEFT");
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                return findWord(crossword, word, x, y, "LEFT");
            }

        }

        idx = 0;
        if (direct.equals("LEFT")) {
            try {
                for (int yy = y; yy > y - size; yy--) {
                    newWord[idx++] = (char) crossword[x][yy];
                }
                if (Arrays.equals(word.toCharArray(), newWord)) {
                    System.out.println("LEFT YES");
                    Word w = new Word(word);
                    w.setStartPoint(y, x);
                    w.setEndPoint(y - size + 1, x);
                    return w;
                } else {
                    return findWord(crossword, word, x, y, "UP");
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                return findWord(crossword, word, x, y, "UP");
            }

        }

        idx = 0;
        if (direct.equals("UP")) {
            try {
                for (int xx = x; xx > x - size; xx--) {
                    newWord[idx++] = (char) crossword[xx][y];
                }
                if (Arrays.equals(word.toCharArray(), newWord)) {
                    System.out.println("UP YES");
                    Word w = new Word(word);
                    w.setStartPoint(y, x);
                    w.setEndPoint(y, x - size + 1);
                    return w;
                    //System.out.println(w);
                } else {
                    return findWord(crossword, word, x, y, "LEFT_UP");
                    //return null;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                return findWord(crossword, word, x, y, "LEFT_UP");
                //return null;
            }

        }

        idx = 0;
        if (direct.equals("LEFT_UP")) {
            int xx = x;
            int yy = y;
            try {
                while (true) {
                    if (idx == size) break;
                    char c = (char) crossword[xx--][yy--];
                    newWord[idx++] = c;
                }
                if (Arrays.equals(word.toCharArray(), newWord)) {
                    System.out.println("LEFT_UP YES");
                    Word w = new Word(word);
                    w.setStartPoint(y, x);
                    w.setEndPoint(++yy, ++xx);
                    return w;

                } else {
                    return findWord(crossword, word, x, y, "LEFT_DOWN");
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                return findWord(crossword, word, x, y, "LEFT_DOWN");
            }
        }

        idx = 0;
        if (direct.equals("LEFT_DOWN")) {
            int xx = x;
            int yy = y;
            try {
                while (true) {
                    if (idx == size) break;
                    char c = (char) crossword[xx++][yy--];
                    newWord[idx++] = c;
                }
                if (Arrays.equals(word.toCharArray(), newWord)) {
                    System.out.println("LEFT_DOWN YES");
                    Word w = new Word(word);
                    w.setStartPoint(y, x);
                    w.setEndPoint(++yy, --xx);
                    return w;

                } else {
                    return findWord(crossword, word, x, y, "RIGHT_UP");
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                return findWord(crossword, word, x, y, "RIGHT_UP");
            }
        }

        idx = 0;
        if (direct.equals("RIGHT_UP")) {
            int xx = x;
            int yy = y;
            try {
                while (true) {
                    if (idx == size) break;
                    char c = (char) crossword[xx--][yy++];
                    newWord[idx++] = c;
                }
                if (Arrays.equals(word.toCharArray(), newWord)) {
                    System.out.println("RIGHT_UP YES");
                    Word w = new Word(word);
                    w.setStartPoint(y, x);
                    w.setEndPoint(--yy, ++xx);
                    return w;

                } else {
                    return findWord(crossword, word, x, y, "RIGHT_DOWN");
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                return findWord(crossword, word, x, y, "RIGHT_DOWN");
            }
        }

        idx = 0;
        if (direct.equals("RIGHT_DOWN")) {
            int xx = x;
            int yy = y;
            try {
                while (true) {
                    if (idx == size) break;
                    char c = (char) crossword[xx++][yy++];
                    newWord[idx++] = c;
                }
                if (Arrays.equals(word.toCharArray(), newWord)) {
                    System.out.println("RIGHT_DOWN YES");
                    Word w = new Word(word);
                    w.setStartPoint(y, x);
                    w.setEndPoint(--yy, --xx);
                    return w;

                } else {
                    return null;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                return null;
            }
        }

        return null;
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        boolean breakk;

        for (String word : words) {
            breakk = false;
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    Word w = findWord(crossword, word, i, j, "RIGHT");
                    if (w != null) {
                        System.out.println(w);
                        list.add(w);
                        breakk = true;
                        break;
                    }
                }
                if (breakk) {
                    break;
                }
            }
        }

        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
