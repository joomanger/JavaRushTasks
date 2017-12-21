package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {
        String fileName;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        }
        String line;
        try (BufferedReader b = new BufferedReader(new FileReader(fileName))) {
            while ((line = b.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " ");
                int i = 0;
                while (st.hasMoreElements()) {
                    String word = st.nextElement().toString();
                    for (String s : words) {
                        if (s.equals(word)) {
                            i++;
                        }
                    }
                }
                // System.out.println(i);
                if (i == 2) {
                    System.out.println(line);
                }
            }
        }
    }
}
