package com.javarush.task.task14.task1421;

/**
 * Created by Alex on 30.07.17.
 */
public class Singleton {
    private static Singleton instance=new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance(){
      return instance;
    }
}
