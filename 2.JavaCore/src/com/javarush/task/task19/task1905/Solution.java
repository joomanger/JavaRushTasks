package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
//   String d="+38(050)123-45-67";
//        System.out.println("callto://+"+d.replaceAll("\\D+",""));

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        private Pattern p= Pattern.compile("^(.+)(\\,\\u0020)(.+)$");

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            for (Map.Entry<String, String> e : countries.entrySet()) {
                if (e.getValue().equals(customer.getCountryName())) {
                    return e.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            Matcher m=p.matcher(contact.getName());
            if(m.find()){
               return m.group(3);
            }
            return null;
        }

        @Override
        public String getContactLastName() {
            Matcher m=p.matcher(contact.getName());
            if(m.find()){
                return m.group(1);
            }
            return null;
        }

        @Override
        public String getDialString() {
            return "callto://+"+contact.getPhoneNumber().replaceAll("\\D+","");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}