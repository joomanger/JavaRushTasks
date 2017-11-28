package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static{
        labels.put(5d,"pa");
        labels.put(6d,"pc");
        labels.put(7d,"pb");
        labels.put(8d,"ps");
        labels.put(9d,"pp");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
