package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        int cnt=0;
        int bytik;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            while (fis.available() > 0) {
                bytik = fis.read();
                if (bytik == 44)
                    cnt++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cnt);


    }
}
