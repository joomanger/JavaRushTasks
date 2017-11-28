package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.nextLine();
        char[] cc = txt.toCharArray();
        StringBuilder vowel = new StringBuilder();
        StringBuilder nvowel = new StringBuilder();
        for (char c : cc) {
          if(c!=' ')
            if (isVowel(c)) {
                vowel.append(c);
                vowel.append(' ');
            } else {
                nvowel.append(c);
                nvowel.append(' ');
            }
        }
        System.out.println(vowel.toString());
        System.out.println(nvowel.toString());
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}