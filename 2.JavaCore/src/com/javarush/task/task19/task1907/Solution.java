package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        br.close();

        FileReader fr = new FileReader(file1);
        StringBuffer sb = new StringBuffer();
        int count = 0;
        while (fr.ready()) {
            int c = fr.read();
            if (c >= 97 && c <= 122) {
                sb.append((char) c);
            } else {
                if (sb.toString().equals("world")) {
                    count++;
                }
                sb.delete(0, sb.capacity());
            }

        }
        fr.close();

        System.out.println(count);

    }
}
