package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> files = new TreeMap<>();
        Pattern p = Pattern.compile("^(.+)(\\.part)(\\d+)$");
        String mainFileName = null;
        //String pathFile="/Work/";
        while (true) {
            String fileName = scanner.nextLine();
            if (fileName.equals("end")) {
                scanner.close();
                break;
            }
            Matcher m = p.matcher(fileName);
            if (m.find()) {
                if (mainFileName == null) {
                    mainFileName = m.group(1).toString();
                }
                files.put(Integer.parseInt(m.group(3).toString()), fileName);
            }
        }

        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(mainFileName));
            for (Map.Entry e : files.entrySet()) {

                bis = new BufferedInputStream(new FileInputStream(e.getValue().toString()));
                if (bis.available() > 0) {
                    byte[] b = new byte[bis.available()];
                    int count = bis.read(b, 0, bis.available());
                    bos.write(b,0,count);
                }
                bis.close();
            }
            bos.close();

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
