package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    private static Map<String, String> files = new HashMap<>();
    private static Set<String> sortedfileNames = new TreeSet<>();
    private static Set<String> delFiles = new HashSet<>();

    //рекурсия
    public static void scan(String path) {
        File f = new File(path);
        if (f.isFile() && f.getAbsoluteFile().getName().toUpperCase().endsWith(".TXT")) {
            if (f.length() <= 50) {
                sortedfileNames.add(f.getAbsoluteFile().getName().toUpperCase());
                files.put(f.getAbsolutePath(), f.getAbsoluteFile().getName().toUpperCase());
            } else {
                delFiles.add(f.getAbsolutePath());
            }
        }

        try {
            for (File file : f.listFiles()) {
                if (f.isDirectory()) {
                    scan(file.getAbsolutePath());
                }
            }
        } catch (NullPointerException ex) {

        }
    }

    public static void main(String[] args) throws Exception {
        String path = args[0];
        //"/Work/files/";
        String resultFileAbsolutePath = args[1];
        //"/Work/result.txt";

        File res_src = new File(resultFileAbsolutePath);
        System.out.println(res_src.getParent());

        String t = "allFilesContent.txt";
        File res_dst = new File(res_src.getParent() + "/" + t);

        if (FileUtils.isExist(res_dst)) {
            FileUtils.deleteFile(res_dst);
        }

        if (FileUtils.isExist(res_src)) {
            FileUtils.renameFile(res_src, res_dst);
        }

        scan(path);

        System.out.println("Рабочие файлы:");
        try (BufferedWriter bos = new BufferedWriter(new FileWriter(res_dst))) {

            for (String f : sortedfileNames) {
                for (Map.Entry<String, String> m : files.entrySet()) {
                    if (m.getValue().equals(f)) {
                        System.out.println(m.getValue() + " " + m.getKey());
                        try (BufferedReader bis = new BufferedReader(new FileReader(m.getKey()))) {
                            String line;
                            while ((line = bis.readLine()) != null) {
                                bos.write(line);
                                bos.newLine();
                            }
                        }
                        bos.write("\n");
                    }
                }
            }
        }

        System.out.println("Удалить файлы:");
        for (String f : delFiles) {
            System.out.println(f);
            FileUtils.deleteFile(new File(f));
        }
    }
}
