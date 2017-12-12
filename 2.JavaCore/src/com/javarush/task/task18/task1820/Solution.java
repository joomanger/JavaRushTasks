package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        scanner.close();

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(fileName1));
            bw = new BufferedWriter(new FileWriter(fileName2));
            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " ");
                StringBuffer sb = new StringBuffer();
                while (st.hasMoreElements()) {
                    sb.append(Math.round(Double.parseDouble(st.nextElement().toString())));
                    sb.append(" ");
                }
                bw.write(sb.toString().trim());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
