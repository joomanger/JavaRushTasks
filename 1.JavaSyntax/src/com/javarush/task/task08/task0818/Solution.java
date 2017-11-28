package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Alex", 1000);
        map.put("Den", 1100);
        map.put("Artem", 800);
        map.put("Vasya", 400);
        map.put("Olga", 200);
        map.put("Alex1", 1000);
        map.put("Den1", 1100);
        map.put("Artem1", 300);
        map.put("Vasya1", 400);
        map.put("Olga1", 200);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = (Map.Entry) it.next();
            if (pair.getValue() < 500) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
    }
}