package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = //"/Work/test.txt";
                scanner.nextLine();
        scanner.close();
        //String[] args2 = {"-c", "alex savin", "1222.25", "111"};
        //String[] args2 = {"-d", "9"};
        //String[] args2 = {"-u", "8", "oleksiy2 savin2", "550", "100"};

        BufferedReader br = null;
        List<String> lines = new ArrayList<>();
        List<String> lines2 = new ArrayList<>();
        String id = args[1];

        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                if (args[0].equals("-d")) {
                    if (id.equals(line.substring(0, 8).trim())) {
                        continue;
                    } else {
                        lines.add(line);
                    }
                }
                if (args[0].equals("-u")) {
                    lines.add(line);
                    lines2.add(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (args[0].equals("-u")) {
            String idd = formatParameter(args[1], 8);
            String productName = formatParameter(args[2], 30);
            String price = formatParameter(args[3], 8);
            String qty = formatParameter(args[4], 4);
            //System.out.println("Обновим ID");
            for (String s : lines) {
                if (id.equals(s.substring(0, 8).trim())) {
                    int idx = lines2.indexOf(s);
                    lines2.remove(idx);
                    lines2.add(idx, idd + productName + price + qty);
                }
            }
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(fileName));
                int idx = 0;
                for (String s : lines2) {
                    if (idx > 0)
                        bw.newLine();
                    bw.write(s);
                    idx++;
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    bw.flush();
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

//        for (String l : lines2) {
//            System.out.println(l);
//        }

        if (args[0].equals("-d")) {
            //System.out.println("Удалим ID");
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(fileName));
                int idx = 0;
                for (String s : lines) {
                    if (idx > 0)
                        bw.newLine();
                    bw.write(s);
                    idx++;
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    bw.flush();
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
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
