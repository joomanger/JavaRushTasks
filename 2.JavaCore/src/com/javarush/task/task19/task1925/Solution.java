package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        String file1 = args[0];//"/Work/test.txt";
        String file2 = args[1];//"/Work/result.txt";
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(file1));
        String line;
        while((line=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line, " ");
            while (st.hasMoreElements()) {
                String val = st.nextElement().toString();
                if (val.length() > 6) {
                    sb.append(val);
                    sb.append(",");
                }
            }
        }
        br.close();

        String data=sb.toString();
        String s = data.substring(0, data.length() - 1);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        bw.write(s);
        bw.close();
    }
}
