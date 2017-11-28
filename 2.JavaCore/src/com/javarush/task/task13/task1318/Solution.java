package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InputStream in = new FileInputStream((br.readLine()));
        while (in.available() > 0) {
            System.out.print((char) in.read());
        }
        System.out.println();

        in.close();
        br.close();

    }
}