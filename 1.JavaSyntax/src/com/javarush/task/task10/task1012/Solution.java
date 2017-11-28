package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        //Arrays.sort(abcArray);

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        Map<Character, Integer> map = new HashMap<>();
        // напишите тут ваш код

        int cnt = 0;
        for (char c : abcArray) {
            //флыофлSystem.out.println(c);
            for (String ss : list) {
                char[] cc = ss.toCharArray();
                //Arrays.sort(cc);
                for (int j = 0; j < cc.length; j++) {
                    if (cc[j] == c) {
                        //System.out.println(c);
                        cnt++;
                    }
                }

            }
            map.put(c, cnt);
            cnt = 0;
        }

        for(char c:alphabet) {


            for (Map.Entry<Character, Integer> en : map.entrySet()) {
                if(c==en.getKey())
                System.out.println(en.getKey() + " " + en.getValue());
            }
        }
    }

}
