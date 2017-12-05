package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        HashMap<Integer, Integer> map = new HashMap<>();

        int bytik;
        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            bytik = fis.read();
            if (map.containsKey(bytik)) {
                map.put(bytik, map.get(bytik) + 1);
            } else {
                map.put(bytik, 1);
            }
        }

        int max_val = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (max_val < e.getValue()) {
                max_val = e.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (max_val == e.getValue()) {
                System.out.print(e.getKey()+" ");
            }
        }

        fis.close();
    }
}
