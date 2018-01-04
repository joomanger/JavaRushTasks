package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.List;

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
            byte[] bytes = Long.toString(i).getBytes();
            long res = 0;
            int pw = Long.toString(i).length();
            for (byte b : bytes) {
                res += Math.pow(Character.getNumericValue((char) b), pw);
            }
            if (res == i) {
                list.add(i);
            }
        }

        for (long ll : list) {
            System.out.println(ll);
        }

        //result = list.toArray();
        //System.out.println("res=" + res);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getNumbers(10000000));
    }
}
