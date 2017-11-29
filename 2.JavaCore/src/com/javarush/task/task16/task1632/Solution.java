package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());

    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);

            } catch (InterruptedException ex) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            while (true)
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    //System.out.println("InterruptedException");
                }
        }
    }

    public static class Thread4 extends Thread implements Message {

        @Override
        public void showWarning() {
            if (isAlive())
                interrupt();
        }

        @Override
        public void run() {

        }
    }

    public static class Thread5 extends Thread {
        //private Scanner scanner = new Scanner(System.in);
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        //List<Integer> digits = new ArrayList<>();

        @Override
        public void run() {
            String dig;
            int sum = 0;
            try {
                while (!((dig = rd.readLine()).equals("N"))) {
                    sum += Integer.parseInt(dig);
                }
                System.out.println(sum);
                rd.close();
            } catch (IOException ex) {
                //rd.close();
                System.err.println("Все накрылось!");
            }

        }
    }


    public static void main(String[] args) {
        //threads.get(4).start();
    }
}