package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        int data = Integer.MIN_VALUE;
        int bytik = Integer.MIN_VALUE;
        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            bytik = fis.read();
            if (bytik > data)
                data = bytik;
        }
        System.out.println(data);
        fis.close();
    }
}
