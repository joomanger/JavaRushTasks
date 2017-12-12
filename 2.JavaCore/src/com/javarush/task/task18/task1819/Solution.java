package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        scanner.close();

        BufferedReader br = null;
        BufferedReader br2 = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(fileName1));
            br2 = new BufferedReader(new FileReader(fileName2));

            String line;
            StringBuffer sb = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            while ((line = br2.readLine()) != null) {
                sb2.append(line);
            }
            StringBuffer sb3 = new StringBuffer();
            sb3.append(sb2.toString());
            sb3.append(sb.toString());
            br.close();
            br2.close();
            bw = new BufferedWriter(new FileWriter(fileName1));
            bw.write(sb3.toString());

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
                br2.close();
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
