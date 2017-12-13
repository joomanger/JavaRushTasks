package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferedReader br;
        String fileName = null;
        try {
            while (true) {
                fileName = scanner.nextLine();
                br = new BufferedReader(new FileReader(fileName));
                br.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(fileName);
            scanner.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
