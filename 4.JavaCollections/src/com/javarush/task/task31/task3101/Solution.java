package com.javarush.task.task31.task3101;

import java.io.File;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        String path = "/Work/files";
        String resultFileAbsolutePath = "/Work/result.txt";

        File f = new File(path);
        if (f.isDirectory()) {
            System.out.println("Its a directory");
        }

        for (File file : f.listFiles()) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
