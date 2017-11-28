package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        if (n > 150)
            return "";
        if (n < 0)
            return "0";
        int cnt = 1;
        BigInteger result = new BigInteger("1");
        while (cnt <= n) {
            result = result.multiply(new BigInteger(String.valueOf(cnt)));
            cnt++;
        }

        return String.valueOf(result);
    }


}
