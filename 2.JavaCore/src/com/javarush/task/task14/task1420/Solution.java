package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int result = 1;

        if (a <= 0 || b <= 0) {
            throw new Exception("невозможно преобразовать в положительные целые числа");
        }

        if (a == 1 || b == 1) {
            //result=1;
            System.out.println(1);
            return;
        }
        ArrayList<Integer> am = getMovs(a);
        //System.out.println();
        ArrayList<Integer> bm = getMovs(b);
        ArrayList<Integer> om = new ArrayList<>();
        if (am.size() <= bm.size()) {
            for (int i = 0; i < bm.size(); i++) {
                for (int j = 0; j < am.size(); j++) {
                    if (bm.get(i) == am.get(j)) {
                        om.add(am.get(j));
                        am.remove(j);
                        am.add(j, -1);
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < am.size(); i++) {
                for (int j = 0; j < bm.size(); j++) {
                    if (am.get(i) == bm.get(j)) {
                        om.add(bm.get(j));
                        bm.remove(j);
                        bm.add(j, -1);
                        break;
                    }
                }
            }
        }

//        System.out.println("");

        for (int i : om) {
//            System.out.println(i);
            result *= i;
        }
        System.out.println(result);

    }

    public static ArrayList<Integer> getMovs(int d) {
        int a = d;
        ArrayList<Integer> dlts = new ArrayList<>();
        int dlt = 2;
        while (true) {
            if (a % dlt == 0) {
                dlts.add(dlt);
                if (a == dlt) {
                    break;
                }
                a = a / dlt;
            } else {
                dlt++;
            }
        }
//        for (int i : dlts) {
//            System.out.println(i);
//        }
        return dlts;
    }
}
