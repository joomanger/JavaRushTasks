package com.javarush.task.task20.task2026;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                int h = 0;
                int l = 0;
                if (a[i][j] == 1) {
                    //вправо
                    for (int jj = j; jj < a[i].length; jj++) {
                        l = jj;
                        if (a[i][jj] == 0) {
                            break;
                        }
                    }
                    //вниз
                    for (int ii = i; ii < a.length; ii++) {
                        h = ii;
                        if (a[ii][j] == 0) {
                            break;
                        }
                    }
                    //диагональ
                    for (int ii = i; ii <= h; ii++) {
                        for (int jj = j; jj <= l; jj++) {
                            a[ii][jj] = -1;
                        }
                    }
                    result++;
                }
            }
        }
        return result;
    }


}
