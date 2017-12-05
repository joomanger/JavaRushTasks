package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        //start here - начни тут
        //System.out.println("sss");
        //List<Person> newPerson=new ArrayList<>();
        int id = 0;
        String name;
        Sex sex;
        Date date;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 3) {
                        name = args[i];
                        sex = args[i + 1].equals("м") ? Sex.MALE : Sex.FEMALE;
                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        try {
                            date = df.parse(args[i + 2]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                            return;
                        }
                        Person p = sex == Sex.MALE ? Person.createMale(name, date) : Person.createFemale(name, date);
                        allPeople.add(p);
                        System.out.println(allPeople.indexOf(p));
                    }
                }
                break;

            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) {
                        id = Integer.parseInt(args[i]);
                        name = args[i + 1];
                        sex = args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE;
                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        try {
                            date = df.parse(args[i + 3]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                            return;
                        }
                        Person p = sex == Sex.MALE ? Person.createMale(name, date) : Person.createFemale(name, date);
                        allPeople.remove(id);
                        allPeople.add(id, p);
                    }
                }
                break;

            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person p = allPeople.get(Integer.parseInt(args[i]));
                        p.setName(null);
                        p.setBirthDay(null);
                        p.setSex(null);
                        allPeople.remove(id);
                        allPeople.add(id, p);
                    }
                }
                break;

            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person p = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(p.getName() + " " + (p.getSex() == Sex.MALE ? "м" : "ж") + " " + (new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)).format(p.getBirthDay()));
                    }
                }
                break;

            default:
                synchronized (allPeople) {
                    throw new IllegalArgumentException();
                }
        }
    }
}
