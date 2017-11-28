package com.javarush.task.task15.task1527;


import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        Scanner scanner=new Scanner(System.in);

        //String url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo&obj=-121212";
        String url = scanner.nextLine();

        StringBuilder b = new StringBuilder();
        Double obj_d = null;
        String obj_s = null;
        Pattern pattern = Pattern.compile("\\?(.*)");
        Matcher matcher = pattern.matcher(url);
        while (matcher.find()) {
            StringTokenizer st = new StringTokenizer(matcher.group(1), "&");
            while (st.hasMoreTokens()) {
                //System.out.println(st.nextToken());
                String param = st.nextToken();
                if (!param.contains("=")) {
                    b.append(param + " ");
                } else {
                    StringTokenizer st2 = new StringTokenizer(param, "=");
                    int i = 0;
                    String pr = null;
                    while (i != 2) {
                        //System.out.println("param="+st2.nextToken());

                        if (i == 0) {
                            pr = st2.nextToken();
                            b.append(pr + " ");
                        } else {
                            //System.out.println("res=" + st2.nextToken());
                            if (pr != null && pr.equals("obj")) {
                                //System.out.println("obj="+st2.nextToken());
                                String result = st2.nextToken();
                                try {
                                    //if (result.contains("."))
                                        obj_d = Double.parseDouble(result);
//                                    else
//                                        obj_s = result;
                                } catch (NumberFormatException ex) {
                                    obj_s = result;
                                }
                            }
                        }
                        i++;
                    }
                }

            }
        }

        String params = b.toString().trim();
        if(params!=null)
        System.out.println(params);
        if (obj_d != null)
            alert(obj_d);
        else if (obj_s!=null)
            alert(obj_s);

        scanner.close();
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
