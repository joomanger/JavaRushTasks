package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        List<Integer> l = null;
        try {
            l = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                l.add(scanner.nextInt());
            }
        } catch (java.util.InputMismatchException e) {
            for (int i : l) {
                System.out.println(i);
            }
        }
    }
}
