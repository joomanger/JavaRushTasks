package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        String file1 = args[0];//"/Work/test.txt";
        String file2 = args[1];//"/Work/result.txt";
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(file1));
        String line;
        while((line=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line, " ");
            Pattern p = Pattern.compile("\\d+");
            Matcher m;
            while (st.hasMoreElements()) {

                String val = st.nextElement().toString();
                m = p.matcher(val);
                if (m.find()) {
                    sb.append(val);
                    sb.append(" ");
                }
            }
        }
        br.close();
      //  System.out.println(sb.toString());
        String data=sb.toString().trim();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        bw.write(data);
        bw.close();
    }
}
