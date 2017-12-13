package com.javarush.task.task18.task1823;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        System.out.println(Byte.toUnsignedInt(Byte.parseByte("-100")));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String fileName = scanner.nextLine();
            if (fileName.equals("exit")) {
                break;
            }

            ReadThread rh=new ReadThread(fileName);
            rh.start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            BufferedInputStream bis = null;
            HashMap<Byte, Integer> map = new HashMap<>();
            try {
                bis = new BufferedInputStream(new FileInputStream(fileName));
                if (bis.available() > 0) {
                    byte[] b = new byte[bis.available()];
                    int count = bis.read(b, 0, bis.available());
                    for (byte bb : b) {
                        try {
                            map.put(bb, map.get(bb) == null ? 1 : map.get(bb) + 1);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                    Integer maxByteCount = Integer.MIN_VALUE;
                    Byte selectedByte = null;
                    for (Map.Entry<Byte, Integer> e : map.entrySet()) {
                        if (maxByteCount < e.getValue()) {
                            maxByteCount = e.getValue();
                            selectedByte = e.getKey();
                        }
                    }
                    resultMap.put(fileName, selectedByte.intValue());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    bis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
