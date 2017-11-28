package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
        Scanner scanner=new Scanner(System.in);
        String date=scanner.nextLine();
        Date d=format.parse(date);
        System.out.println((new SimpleDateFormat("MMM",Locale.ENGLISH).format(d)).toUpperCase()
                +" "+new SimpleDateFormat("dd",Locale.ENGLISH).format(d)
                +", "+new SimpleDateFormat("yyyy",Locale.ENGLISH).format(d)
        );

    }
}
