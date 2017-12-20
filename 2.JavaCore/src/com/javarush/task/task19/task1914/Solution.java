package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(outputStream.toString());

        //Возвращаем все как было
        System.setOut(consoleStream);

        int[] d = new int[2];
        int idx = 0;
        while (m.find())
            d[idx++] = Integer.parseInt(m.group());


        p = Pattern.compile("[\\+\\-\\*]");
        Matcher m2 = p.matcher(outputStream.toString());
        int result = 0;
        while (m2.find()) {
            switch (m2.group()) {
                case "+":
                    result = d[0] + d[1];
                    break;
                case "-":
                    result = d[0] - d[1];
                    break;
                case "*":
                    result = d[0] * d[1];
                    break;
                default:

            }
        }
        System.out.println(outputStream.toString().replaceAll("\\n", "") + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

