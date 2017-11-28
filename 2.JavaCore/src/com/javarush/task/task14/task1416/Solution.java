package com.javarush.task.task14.task1416;

/* 
Исправление ошибок
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String mydata="99_as_filename.xlsx";
        System.out.println(mydata);
        //String mydata = "some string with 'the data i want' inside";
        Pattern pattern = Pattern.compile("^[0-9]+((?=.*\\.XLS$)|(?=.*\\.XLSX$))");
        Matcher matcher = pattern.matcher(mydata.toUpperCase());
        if (matcher.find())
        {
            System.out.println(matcher.group(0));
        }

        String t="asasas.xls";
        System.out.println(t.toUpperCase().endsWith(".XLS"));


        Swimmable animal = new Orca();
        animal.swim();
        animal = new Whale();
        animal.swim();
        animal = new Otter();
        animal.swim();
    }

    public static void test(Swimmable animal) {
        animal.swim();
    }

    static interface Walkable {
        void walk();
    }

    static interface Swimmable {
        void swim();
    }

    static abstract class OceanAnimal  {
        public void swim() {
            OceanAnimal currentAnimal = (OceanAnimal) getCurrentAnimal();
            currentAnimal.swimming();
        }

        public void swimming() {
            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is swimming");
        }

        abstract Swimmable getCurrentAnimal();
    }

    static class Orca extends OceanAnimal implements Swimmable {
        @Override
        Swimmable getCurrentAnimal() {
            return this;
        }
    }

    static class Whale extends OceanAnimal implements Swimmable {

        @Override
        Swimmable getCurrentAnimal() {
            return this;
        }
    }

    static class Otter implements Swimmable,Walkable {
        @Override
        public void walk() {

        }

        @Override
        public void swim() {

        }


    }
}
