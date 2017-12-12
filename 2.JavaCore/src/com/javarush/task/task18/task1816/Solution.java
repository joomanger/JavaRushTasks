package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        //97 and 122; 65 and 85
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(args[0]));
            String line;
            int cnt = 0;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    int chr = (int) line.charAt(i);
                    if ((chr >= 97 && chr <= 122) || (chr >= 65 && chr <= 90))
                        cnt++;
                }
            }
            System.out.println(cnt);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
