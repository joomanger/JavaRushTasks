package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = //"c:/apps/test.txt";
                br.readLine();
        br.close();

        try (BufferedReader b = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = b.readLine()) != null) {
                StringTokenizer at = new StringTokenizer(line, " ");
                StringBuffer sb = new StringBuffer();
                while (at.hasMoreElements()) {
                    String word = at.nextElement().toString();
                    try {
                        int a = Integer.parseInt(word);
                        if (a >= 0 && a <= 12) {
                            //System.out.print(map.get(a)+" ");
                            sb.append(map.get(a));
                            sb.append(" ");
                        } else {
                            //System.out.print(word+" ");
                            sb.append(word);
                            sb.append(" ");
                        }
                    } catch (NumberFormatException ex) {
                        //System.out.print(word+" ");
                        sb.append(word);
                        sb.append(" ");
                    }
                }
                System.out.println(sb.toString().trim());
            }
        }
    }
}
