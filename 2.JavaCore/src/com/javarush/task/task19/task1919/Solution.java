package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Solution {
    private static Map<String, Double> map = new TreeMap<>();
    //private static StringBuffer bf = new StringBuffer();

    public static void addValue(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        String name = st.nextElement().toString();
        Double salary = Double.parseDouble(st.nextElement().toString());
        map.put(name, map.get(name) == null ? salary : map.get(name) + salary);
        //bf.delete(0, bf.capacity());
    }

    public static void main(String[] args) throws Exception {
        String fileName = //"/Work/test.txt";
                args[0];
        BufferedReader fr = new BufferedReader(new FileReader(fileName));

        while (fr.ready()) {
            String line = fr.readLine();
            addValue(line);
        }
        //addValue();
        fr.close();

        for (Map.Entry<String, Double> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

    }
}
