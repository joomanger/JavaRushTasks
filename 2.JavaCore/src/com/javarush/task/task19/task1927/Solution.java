package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();
        ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
        int idx = 0;
        for (byte b : outputStream.toByteArray()) {
            outputStream2.write(b);
            if (b == 10) {
                idx++;
                if (idx % 2 == 0) {
                    try {
                        outputStream2.write("JavaRush - курсы Java онлайн\n".getBytes());
                    }catch (IOException ex){
                        ex.printStackTrace();
                    }
                }
            }
        }

        //Преобразовываем записанные в наш ByteArray данные в строку
        //String result = outputStream.toString().toUpperCase();

        //Возвращаем все как было
        System.setOut(consoleStream);


        System.out.println(outputStream2);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

