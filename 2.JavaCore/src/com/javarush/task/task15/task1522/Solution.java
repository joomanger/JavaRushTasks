package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static{
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        //Planet thePlanet = null;
        if (value.equals(Planet.EARTH)) {
             thePlanet = Earth.getInstance();
//            System.out.println("e");
        } else if (value.equals(Planet.MOON)) {
             thePlanet = Moon.getInstance();
//            System.out.println("m");
        } else if (value.equals(Planet.SUN)) {
             thePlanet = Sun.getInstance();
//            System.out.println("s");
        } else {
             thePlanet = null;
        }


    }
}
