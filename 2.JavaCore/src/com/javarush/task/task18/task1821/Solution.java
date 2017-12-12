package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/Work/test.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    int val;
                    try {
                        val = map.get((int) line.charAt(i)) + 1;
                    } catch (Exception ex) {
                        val = 1;
                    }
                    map.put((int) line.charAt(i), val);
                }
            }
            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                System.out.println(Character.toString((char) m.getKey().intValue()) + " " + m.getValue());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
