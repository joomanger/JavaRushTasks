package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
//        try {
//            Scanner scanner = new Scanner(new FileInputStream(new File("c:\\apps\\file1.txt")), "CP1251");
//            PersonScanner ps = new PersonScannerAdapter(scanner);
//            Person person;
//
//            while ((person = ps.read()) != null) {
//                System.out.println(person.toString());
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        // @Override
        public Person read() {
            String lastName;
            String firstName;
            String middleName;
            Date d;
            try {
                String line = fileScanner.nextLine();
                StringTokenizer st = new StringTokenizer(line, " ");

                lastName = st.nextElement().toString();
                firstName = st.nextElement().toString();
                middleName = st.nextElement().toString();
                String dd = st.nextElement().toString();
                String mm = st.nextElement().toString();
                String yyyy = st.nextElement().toString();
                String date = dd + "." + mm + "." + yyyy;
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    d = df.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return null;
                }

            } catch (java.util.NoSuchElementException ex) {
                return null;
            }

            return new Person(firstName, middleName, lastName, d);
        }

        @Override
        public void close() {
            fileScanner.close();
        }


    }


}
