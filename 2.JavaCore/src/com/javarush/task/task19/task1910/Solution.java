package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();

        BufferedReader fr = new BufferedReader(new FileReader(file1));
        StringBuffer sb = new StringBuffer();
        while (fr.ready()) {
            sb.append(fr.readLine());
        }
        fr.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        String s = sb.toString();

        bw.write(s.replaceAll("\\p{Punct}", ""));
        bw.flush();
        bw.close();
    }
}
