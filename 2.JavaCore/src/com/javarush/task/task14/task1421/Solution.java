package com.javarush.task.task14.task1421;

/* 
Singleton
*/
public class Solution {
    public static void main(String[] args){
        Singleton s=Singleton.getInstance();
        System.out.println(s);
        Singleton s2=Singleton.getInstance();
        System.out.println(s2);
    }
}
