package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws Exception {
        System.out.println(new Solution(4));
        OutputStream fos = new FileOutputStream("/Work/test.txt");
        Solution savedObject = new Solution(10);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(savedObject);
        oos.close();
        fos.flush();
        fos.close();
        InputStream is = new FileInputStream("/Work/test.txt");
        ObjectInputStream ois = new ObjectInputStream(is);
        Solution loadedObject = new Solution(20);
        System.out.println(loadedObject);
        loadedObject = (Solution) ois.readObject();
        System.out.println(loadedObject);
        System.out.println(savedObject.string.equals(loadedObject.string));
        ois.close();
        is.close();
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
