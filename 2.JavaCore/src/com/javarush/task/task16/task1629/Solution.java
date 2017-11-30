package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        t1.start();
        t1.join();
        Read3Strings t2 = new Read3Strings();
        t2.start();
        t2.join();
        //add your code here - добавьте код тут
        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {
        private StringBuilder sb=new StringBuilder();
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    sb.append(reader.readLine().toString());
                } catch (IOException ex) {

                }
                if (i != 2) {
                    sb.append(" ");
                }
            }
        }

        public void printResult() {
            System.out.println(sb);
        }
    }
}