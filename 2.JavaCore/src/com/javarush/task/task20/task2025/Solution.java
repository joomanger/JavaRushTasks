package com.javarush.task.task20.task2025;

import java.util.*;


import static com.javarush.task.task20.task2025.ArmstrongNumbersMultiSetLongOpt.generate;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
//        if (N < 0) {
//            return null;
//        }

        long[] result=null;
        try {
            List<Long> list = generate(Long.toString(N).length());
            result = list.stream().mapToLong(l -> l).toArray();
            System.out.println(result.length);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return result;
    }

    public static void main(String[] args) {
        long time = Calendar.getInstance().getTimeInMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        System.out.println("Time=" + (Calendar.getInstance().getTimeInMillis() - time));
    }
}
