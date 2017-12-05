package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    //-u id name sex bd
    public static void main(String[] args) {
        //start here - начни тут
        int id = 0;
        String name = "";
        Sex sex = null;
        Date date = null;
        try {
            if (args[0].equals("-c")) {
                name = args[1];
                sex = args[2].equals("м") ? Sex.MALE : Sex.FEMALE;
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                try {
                    date = df.parse(args[3]);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }
            } else {
                id = Integer.parseInt(args[1]);
                name = args[2];
                sex = args[3].equals("м") ? Sex.MALE : Sex.FEMALE;
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                try {
                    date = df.parse(args[4]);
                   //System.out.println(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }
            }
        } catch (Exception ex) {

        }


        if (args[0].equals("-u")) {
            Person p = allPeople.get(id);
            p.setName(name);
            p.setBirthDay(date);
            p.setSex(sex);
            allPeople.remove(id);
            allPeople.add(id, p);
            //System.out.println(p.getName());
            //System.out.println(allPeople.size());
        }
        if (args[0].equals("-c")) {
            Person p;
            if (sex == Sex.MALE) {
                p = Person.createMale(name, date);
            } else {
                p = Person.createFemale(name, date);
            }
            allPeople.add(p);
            System.out.println(allPeople.indexOf(p));
        }
        if (args[0].equals("-d")) {
            Person p = allPeople.get(id);
            p.setName(null);
            p.setBirthDay(null);
            p.setSex(null);
            allPeople.remove(id);
            allPeople.add(id, p);
        }
        if (args[0].equals("-i")) {
            Person p = allPeople.get(id);
            System.out.println(p.getName() + " " + (p.getSex() == Sex.MALE ? "м" : "ж") + " " + (new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)).format(p.getBirthDay()));
        }

//        for (Person p : allPeople) {
//            System.out.println(p.getName() + " " + (p.getSex() == Sex.MALE ? "м" : "ж") + " " + (new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)).format(p.getBirthDay()));
//        }

    }

}
