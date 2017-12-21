package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();


    public static void main(String[] args) throws Exception {
        String fileName = //"/Work/test.txt";
                args[0];
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        Pattern p;
        Matcher m;
        while (fr.ready()) {
            String line = fr.readLine();
            p = Pattern.compile("\\d+");
            m = p.matcher(line);
            StringBuffer bf = new StringBuffer();
            while (m.find()) {
                bf.append(m.group());
                bf.append(" ");
            }
            String date = bf.toString().trim();
            SimpleDateFormat format = new SimpleDateFormat("dd M yyyy");
            Date d = format.parse(date);
            System.out.println(d);

            p = Pattern.compile("\\D+");
            m = p.matcher(line);
            String name = null;
            if (m.find()) {
                //System.out.println(m.group().trim());
                name = m.group().trim();
            }
            PEOPLE.add(new Person(name, d));
        }
        fr.close();

//        for (Person pp : PEOPLE) {
//            System.out.println(pp.getName() + " " + pp.getBirthday());
//        }


    }
}

