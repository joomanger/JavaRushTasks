package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> list = new ArrayList<>();
        System.out.println("N=" + N);
        //System.out.println(Long.toString(N).length());
        for (long i = 0; i <= N; i++) {
//            IntStream bytes = Long.toString(i).chars();
//            int[] ii = bytes.map(new IntUnaryOperator() {
//                @Override
//                public int applyAsInt(int i) {
//                    return i;
//                }
//            }).toArray();
            int[] digits = Long.toString(i).chars().map(c -> c-='0').toArray();
            long res = 0;
            int pw = Long.toString(i).length();
            for (int f : digits) {
                res += Math.pow( f, pw);
            }
            if (res == i) {
                list.add(i);
            }
        }

//        for (long ll : list) {
//            System.out.println(ll);
//        }

        //result = list.toArray();
        //System.out.println("res=" + res);
        return result;
    }

    public static void main(String[] args) {
        long time = Calendar.getInstance().getTimeInMillis();
        System.out.println(getNumbers(10000000));
        // System.out.println((byte)5);
        IntStream bytes = Long.toString(370).chars();
        int[] ii = bytes.map(new IntUnaryOperator() {
            @Override
            public int applyAsInt(int i) {
                return i;
            }
        }).toArray();
        System.out.println((char) ii[0] + " " + (char) ii[1]);

        System.out.println(Calendar.getInstance().getTimeInMillis() - time);
    }
}
