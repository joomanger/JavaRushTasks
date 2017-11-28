package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        ArrayList<String> rows = new ArrayList<>();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String ss = null;
        while (!(ss = br.readLine()).equals("exit")) {
            rows.add(ss);
        }
        rows.add("exit");


        for (String s : rows) {
            bw.write(s);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
