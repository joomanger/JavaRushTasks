package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();

        FileReader fr = new FileReader(file1);/*"c:\\apps\\file1.txt"*/
        List<Character> cc = new ArrayList<>();
        while (fr.ready()) {
            cc.add((char) fr.read());
        }
        fr.close();

        Object[] s = cc.toArray();

        FileWriter fw = new FileWriter(file2); /*"c:\\apps\\result.txt"*/
        for (int i = 0; i < s.length; i++) {
            if (i % 2 != 0) {
                fw.write(s[i].toString());
            }
        }
//        for (Character r : cc) {
//            if (k != id)
//                fw.write(r.toString() + ", ");
//            else
//                fw.write(r.toString());
//
//            k++;
//
//        }
        fw.flush();
        fw.close();
    }
}
