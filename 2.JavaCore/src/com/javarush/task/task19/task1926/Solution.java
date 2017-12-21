package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        while (br.ready()) {
            sb.append(br.readLine());
            System.out.println(sb.reverse().toString());
            sb.delete(0, sb.capacity());
        }
        br.close();
    }
}
