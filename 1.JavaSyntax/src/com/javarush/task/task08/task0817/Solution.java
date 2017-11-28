package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Savin1", "Alex");
        map.put("Savin2", "Alex3");
        map.put("Savin3", "Alex");
        map.put("Savin4", "Alex1");
        map.put("Savin5", "Alex");
        map.put("Savin6", "Alex1");
        map.put("Savin7", "Alex");
        map.put("Savin8", "Alex1");
        map.put("Savin9", "Alex");
        map.put("Savin10", "Alex2");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        int i;
        List<String> names = new ArrayList<>();

        for (Map.Entry<String, String> pair : map.entrySet()) {
            i = 0;
            for (Map.Entry<String, String> pair2 : map.entrySet()) {
                if (pair2.getValue().equals(pair.getValue())) {
                    i++;
                }
            }
            if (i > 1) {
                names.add(pair.getValue());
            }
        }

        for (String n : names) {
            removeItemFromMapByValue(map, n);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
