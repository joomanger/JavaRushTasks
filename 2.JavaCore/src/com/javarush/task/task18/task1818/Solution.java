package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        String file3 = scanner.nextLine();
        scanner.close();

        BufferedReader br2 = null;
        BufferedReader br3 = null;
        BufferedWriter bw = null;
        try {
            br2 = new BufferedReader(new FileReader(file2));
            br3 = new BufferedReader(new FileReader(file3));
            StringBuffer sb2 = new StringBuffer();
            StringBuffer sb3 = new StringBuffer();
            String line;
            while ((line = br2.readLine()) != null) {
                sb2.append(line);
            }
            while ((line = br3.readLine()) != null) {
                sb3.append(line);
            }
            br2.close();
            br3.close();

            StringBuffer sb = new StringBuffer();
            sb.append(sb3.toString());
            sb.append(sb2.toString());
            bw = new BufferedWriter(new FileWriter(file1, true));
            bw.write(sb2.toString());
            bw.write(sb3.toString());
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br2.close();
                br3.close();
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }
}
