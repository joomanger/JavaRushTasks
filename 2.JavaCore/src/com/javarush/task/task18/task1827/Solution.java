package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = //"/Work/test.txt";
                scanner.nextLine();
        scanner.close();
        //String[] args2 = {"-c", "alex savin", "1222.25", "111"};

        if (args[0].equals("-c")) {
            //Проверим параметры
            //product name
            String productName = formatParameter(args[1], 30);
            String price = formatParameter(args[2], 8);
            String qty = formatParameter(args[3], 4);
//            System.out.println(qty);
//            System.out.println(productName);
//            System.out.println(price);

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            List<Integer> idx = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                idx.add(Integer.parseInt((line.substring(0, 8)).trim()));
            }
            br.close();

            int max_id;
            if (idx.size() > 0) {
                max_id = Integer.MIN_VALUE;
                for (int i : idx) {
                    //System.out.println(i);
                    if (max_id < i) {
                        max_id = i;
                    }
                }
                max_id++;
            } else {
                max_id = 1;
            }

            String newId = formatParameter(String.valueOf(max_id), 8);

            //System.out.println("max_id=" + ++max_id);
            //System.out.println(max_id);
            //max_id++;
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            //if (max_id > 1)
                //bw.newLine();
            bw.write(newId + productName + price + qty);
            bw.flush();
            bw.close();


        }
    }

    public static String formatParameter(String value, Integer length) {
        String result;
        if (value.length() > length)
            result = value.substring(0, length);
        else
            result = value;

        if (result.length() < length) {
            char[] repeat = new char[length - result.length()];
            Arrays.fill(repeat, ' ');
            result += new String(repeat);
        }
        return result;
    }
}
