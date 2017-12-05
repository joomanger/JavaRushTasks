package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        TreeSet<Integer> set=new TreeSet<>();

        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            set.add(fis.read());
        }

        for (Integer i:set) {
            System.out.print(i+" ");
        }

        fis.close();
    }
}
