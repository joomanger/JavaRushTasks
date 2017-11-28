package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(isDateOdd("JANUARY 1 2020"));
    }

    public static boolean isDateOdd(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH);

        Date dt = null;
        Calendar c = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        try {
            dt = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        c.setTime(dt);
        c2.set(c.get(Calendar.YEAR), 0, 0);

        Date dt2 = c2.getTime();
        long diff = dt.getTime() - dt2.getTime();
        if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) == 0) return true;
        if ((TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) - 1) % 2 == 0)
            return false;
        else
            return true;

    }
}
