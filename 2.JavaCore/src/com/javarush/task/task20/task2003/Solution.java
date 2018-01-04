package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    //private static Properties  prop = new Properties();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        String fileName;
        try {
            fileName = //"/Work/test.txt";
            console.readLine();
            fis = new FileInputStream(fileName);
            try {
                load(fis);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                console.close();
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        for (String s : prop.stringPropertyNames()) {
            properties.put(s, prop.getProperty(s));
        }
    }

    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.fillInPropertiesMap();
//        FileOutputStream w = new FileOutputStream(new File("/Work/result.txt"));
//        s.save(w);
//        w.close();
    }
}
