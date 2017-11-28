package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Savin1", "Alex1");
        map.put("Savin2", "Alex1");
        map.put("Savin3", "Alex1");
        map.put("Savin4", "Alex1");
        map.put("Savin5", "Alex2");
        map.put("Savin6", "Alex2");
        map.put("Savin7", "Alex3");
        map.put("Savin8", "Alex3");
        map.put("Savin9", "Alex3");
        map.put("Savin10", "Alex4");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int i = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name)) {
                i++;
            }
        }
        return i;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int i = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(lastName)) {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
