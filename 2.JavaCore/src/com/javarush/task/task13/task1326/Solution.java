package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        ArrayList<Integer> list = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String ss = null;

            while ((ss = br.readLine()) != null) {
                //System.out.println(Integer.parseInt(ss));
                list.add(Integer.parseInt(ss));
            }
        }


        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list2.add(list.get(i));

            }
        }

        Object[] t = list2.toArray();
        Arrays.sort(t);
        for (Object tt : t) {
            System.out.println(tt);
        }


    }
}
