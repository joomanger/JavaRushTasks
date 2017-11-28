package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("aaa", "aaa");
        map.put("aaa2", "aaa");
        map.put("aaa3", "aaa");
        map.put("aaa4", "aaa");
        map.put("aaa5", "aaa");
        map.put("aaa6", "aaa");
        map.put("aaa7", "aaa");
        map.put("aaa8", "aaa");
        map.put("aaa9", "aaa");
        map.put("aaa", "aaa");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
