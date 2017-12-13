package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        //String[] args1 = {"-e", "c:\\apps\\file1.txt", "c:\\apps\\file1_enc.txt"};
        //String[] args1 = {"-d", "c:\\apps\\file1_enc.txt","c:\\apps\\file1new.txt"};

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(args[1]));
            bos = new BufferedOutputStream(new FileOutputStream(args[2]));
            if (args[0].equals("-e")) {
                if (bis.available() > 0) {
                    byte[] b = new byte[bis.available()];
                    byte[] b2 = new byte[bis.available()];
                    int count = bis.read(b, 0, bis.available());

                    for (int i = 0; i < b.length; i++) {
                        //System.out.println( b[i]);
                        if (b[i] == 127)
                            b2[i] = 0;
                        else
                            b2[i] = ++b[i];
                        //System.out.println("---"+b2[i]);
                    }
                    bos.write(b2);
                }
            }
            if (args[0].equals("-d")) {
                if (bis.available() > 0) {
                    byte[] b = new byte[bis.available()];
                    byte[] b2 = new byte[bis.available()];
                    int count = bis.read(b, 0, bis.available());

                    for (int i = 0; i < b.length; i++) {
                        //System.out.println( b[i]);
                        if (b[i] == 0)
                            b2[i] = 127;
                        else
                            b2[i] = --b[i];
                        //System.out.println("---"+b2[i]);
                    }
                    bos.write(b2);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
