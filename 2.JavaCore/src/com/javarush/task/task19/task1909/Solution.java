package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
            int c = fr.read();
            if (c == 46)
                c = 33;
            sb.append((char) c);
        }
        fr.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
