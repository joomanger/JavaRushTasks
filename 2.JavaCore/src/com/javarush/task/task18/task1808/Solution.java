package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        String fileName3 = scanner.nextLine();
        FileInputStream inputStream = null;
        FileOutputStream outputStream1 = null;
        FileOutputStream outputStream2 = null;
        scanner.close();
        try {
            inputStream = new FileInputStream(fileName1);
            outputStream1 = new FileOutputStream(fileName2);
            outputStream2 = new FileOutputStream(fileName3);
            if (inputStream.available() > 0) {
                //читаем весь файл одним куском
                byte[] buffer = new byte[inputStream.available()];

                int count = inputStream.read(buffer);
                if(count%2==0) {
                    outputStream1.write(buffer, 0, count / 2);
                    outputStream2.write(buffer, count / 2, count);
                }else{
                    outputStream1.write(buffer, 0, count / 2);
                    outputStream2.write(buffer, count / 2+1, count);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream1.close();
                outputStream2.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }
}
