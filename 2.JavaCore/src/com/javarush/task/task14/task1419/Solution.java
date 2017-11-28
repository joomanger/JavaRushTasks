package com.javarush.task.task14.task1419;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.nio.channels.AcceptPendingException;
import java.nio.file.AccessDeniedException;
import java.rmi.AccessException;
import java.rmi.StubNotFoundException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        exceptions.add(new RuntimeException());
        exceptions.add(new ArithmeticException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new KeyStoreException());
        exceptions.add(new KeyManagementException());
        exceptions.add(new AcceptPendingException());
        exceptions.add(new NegativeArraySizeException());
        exceptions.add(new SecurityException());
        exceptions.add(new NullPointerException());

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}
