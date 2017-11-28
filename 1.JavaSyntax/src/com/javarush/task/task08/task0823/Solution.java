package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        StringTokenizer t = new StringTokenizer(s, " ");
        StringBuilder b = new StringBuilder();
        while (t.hasMoreTokens()) {
            String word = t.nextToken();
            b.append(word.substring(0, 1).toUpperCase());
            b.append(word.substring(1));
            b.append(" ");
        }

        System.out.println(b.toString().trim());
    }
}
