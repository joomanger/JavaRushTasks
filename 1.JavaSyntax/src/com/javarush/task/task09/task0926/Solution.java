package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        int[] m1 = new int[5];
        int[] m2 = new int[2];
        int[] m3 = new int[4];
        int[] m4 = new int[7];
        int[] m5 = new int[0];
        for (int i = 0; i < m1.length; i++) {
            m1[i] = i;
        }
        for (int i = 0; i < m2.length; i++) {
            m2[i] = i;
        }
        for (int i = 0; i < m3.length; i++) {
            m3[i] = i;
        }
        for (int i = 0; i < m4.length; i++) {
            m4[i] = i;
        }
        for (int i = 0; i < m5.length; i++) {
            m5[i] = i;
        }
        ArrayList<int[]> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
