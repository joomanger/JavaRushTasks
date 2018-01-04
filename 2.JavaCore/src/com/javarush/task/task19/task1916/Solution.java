package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = "/Work/test.txt";
                //console.readLine();
        String fileName2 = "/Work/test.part01";
                //console.readLine();
        console.close();
//        List<String> f1 = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(fileName1))) {
//            while (br.ready()) {
//                f1.add(br.readLine());
//
//            }
//        }
        //int idx = 0;
        BufferedReader br = new BufferedReader(new FileReader(fileName1));
        BufferedReader br2 = new BufferedReader(new FileReader(fileName2));
            //List<String> lines1=new ArrayList<>();
            Type t = Type.SAME;
            while (br.ready()) {
                while (br2.ready()) {
                    String line = br.readLine();
                    String line2 = br2.readLine();
                    //System.out.println(line + " " + line2);
                    if (line == null && t.equals(Type.SAME)) {
                        lines.add(new LineItem(Type.ADDED, line2));
                        t = Type.ADDED;
                    } else if (line.equals(line2) && (t.equals(Type.ADDED) || t.equals(Type.REMOVED))) {
                        //System.out.println("aaaa");
                        lines.add(new LineItem(Type.SAME, line));
                        t = Type.SAME;
                    } else if (line.isEmpty() && t.equals(Type.SAME)) {
                        lines.add(new LineItem(Type.ADDED, line2));
                        t = Type.ADDED;
                    } else if (line2.isEmpty() && t.equals(Type.SAME)) {
                        lines.add(new LineItem(Type.REMOVED, line));
                        t = Type.REMOVED;
                    }
                }
                if (br.ready() && t.equals(Type.SAME)) {
                    lines.add(new LineItem(Type.REMOVED, br.readLine()));
                }
            }
            for (LineItem li : lines) {
                System.out.println(li.type + " " + li.line);
            }
       // }
        br.close();
        br2.close();


    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
