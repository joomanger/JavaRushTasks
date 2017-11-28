package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                Thread t = Thread.currentThread();
                while (!t.isInterrupted()) {
                    Thread.sleep(1000);
                    System.out.print(countSeconds + " ");
                    countSeconds -= 1;

                }
            } catch (InterruptedException ex) {
                if (countSeconds == 0) {
                    System.out.printf("Марш!");
                } else {
                    System.out.printf("1 Прервано!");
                }
            }
        }
    }
}
