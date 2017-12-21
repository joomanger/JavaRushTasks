package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Solution {
    private static Map<String, Double> map = new TreeMap<>();

    public static void addValue(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        String name = st.nextElement().toString();
        Double salary = Double.parseDouble(st.nextElement().toString());
        map.put(name, map.get(name) == null ? salary : map.get(name) + salary);
    }

    public static void main(String[] args) throws Exception {
        String fileName = //"/Work/test.txt";
        args[0];
        BufferedReader fr = new BufferedReader(new FileReader(fileName));

        while (fr.ready()) {
            String line = fr.readLine();
            addValue(line);
        }
        fr.close();

        double max_salary = Double.MIN_VALUE;
        for (Map.Entry<String, Double> e : map.entrySet()) {
            if (max_salary < e.getValue())
                max_salary = e.getValue();
        }
        Set<String> names = new TreeSet<>();
        for (Map.Entry<String, Double> e : map.entrySet()) {
            if (max_salary == e.getValue())
                names.add(e.getKey());
        }

        for (String s : names) {
            System.out.println(s);
        }
    }
}
