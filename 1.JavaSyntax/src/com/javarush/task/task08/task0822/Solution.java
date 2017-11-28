package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // find minimum here — найти минимум тут
        Object[] arr = array.toArray();
        Arrays.sort(arr);
        return (int) arr[0];
    }

    public static List<Integer> getIntegerList() throws IOException {
        //create and initialize a list here - создать и заполнить список тут
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        for (int i = 0; i < cnt; i++) {
            list.add(scanner.nextInt());
        }
        return list;
    }
}
