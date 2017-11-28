package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone1", new Date("NOVEMBER 1 1980"));
        map.put("Stallone2", new Date("JUNE 1 1980"));
        map.put("Stallone3", new Date("NOVEMBER 1 1980"));
        map.put("Stallone4", new Date("JUNE 1 1980"));
        map.put("Stallone5", new Date("NOVEMBER 1 1980"));
        map.put("Stallone6", new Date("JUNE 1 1980"));
        map.put("Stallone7", new Date("NOVEMBER 1 1980"));
        map.put("Stallone8", new Date("JUNE 1 1980"));
        map.put("Stallone9", new Date("NOVEMBER 1 1980"));
        map.put("Stallone10", new Date("JUNE 1 1980"));
        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        System.out.println("sss");
        HashMap<String, Date> copy = new HashMap<>(map);
        for (Map.Entry<String, Date> pair : copy.entrySet()) {
            if (((Date) pair.getValue()).getMonth() == 5 || ((Date) pair.getValue()).getMonth() == 6 || ((Date) pair.getValue()).getMonth() == 7)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
    }
}
