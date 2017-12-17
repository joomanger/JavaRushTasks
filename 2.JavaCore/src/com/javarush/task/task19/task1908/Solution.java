package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.StringTokenizer;

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
            sb.append((char) c);
        }
        fr.close();

        String str = sb.toString();
//        System.out.println(str);
        StringTokenizer st = new StringTokenizer(str, " ");
        sb.delete(0, sb.capacity());
        while (st.hasMoreElements()) {
            try {
                sb.append(Integer.parseInt(st.nextElement().toString()));
                sb.append(" ");
            } catch (NumberFormatException ex) {

            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        //System.out.println(sb.toString().trim());
        //
    }
}
