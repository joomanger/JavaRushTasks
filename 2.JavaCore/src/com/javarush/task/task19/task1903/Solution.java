package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    public static class Test implements IncomeData {
        @Override
        public String getCountryCode() {
            return "UA";
        }

        @Override
        public String getCompany() {
            return "dklfhjdjfhj";
        }

        @Override
        public String getContactFirstName() {
            return "Alex";
        }

        @Override
        public String getContactLastName() {
            return "Savin";
        }

        @Override
        public int getCountryPhoneCode() {
            return 38;
        }

        @Override
        public int getPhoneNumber() {
            return 5014;
        }
    }

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        Test t = new Test();
        IncomeDataAdapter d = new IncomeDataAdapter(t);
        System.out.println(d.getName() + " " + d.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();//"Ivanov, Ivan";
        }

        @Override
        public String getPhoneNumber() {
            int phoneNumber = data.getPhoneNumber();
            String phoneNum = formatParameter(String.valueOf(phoneNumber), 10);
            StringBuffer bf = new StringBuffer();
            bf.append("+").append(data.getCountryPhoneCode()).append("(").append(phoneNum.substring(0, 3)).append(")").append(phoneNum.substring(3, 6));
            bf.append("-").append(phoneNum.substring(6, 8)).append("-").append(phoneNum.substring(8, 10));

            return bf.toString();
        }

        private static String formatParameter(String value, Integer length) {
            String result;
            if (value.length() > length)
                result = value.substring(0, length);
            else
                result = value;

            if (result.length() < length) {
                char[] repeat = new char[length - result.length()];
                Arrays.fill(repeat, '0');
                result = new String(repeat)+result;
            }
            return result;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
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