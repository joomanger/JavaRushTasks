package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String fileFrom = scanner.nextLine();
        String fileTo = scanner.nextLine();
        scanner.close();

        FileInputStream inputStream = new FileInputStream(fileFrom);
        FileOutputStream outputStream = new FileOutputStream(fileTo);

        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            for (int i = buffer.length - 1; i >= 0; i--) {
                outputStream.write(buffer[i]);
            }
        }

        inputStream.close();
        outputStream.close();
    }
}
