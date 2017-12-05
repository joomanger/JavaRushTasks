package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String fileName = scanner.nextLine();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fileName);
                if (fis.available() < 1000){
                    fis.close();
                    scanner.close();
                    throw new DownloadException();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
