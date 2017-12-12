package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(args[0]));
            String line;
            int cnt = 0;
            int spc = 0;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    cnt++;
                    int chr = (int) line.charAt(i);
                    if (chr == 32)
                        spc++;
                }
            }
            double result = (spc * 1.00 / cnt) * 100;
            result = Math.round(result * 100) * 1.00 / 100;
            System.out.println(result);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
