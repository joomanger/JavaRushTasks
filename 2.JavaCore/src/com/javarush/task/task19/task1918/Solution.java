package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "c:/apps/test.txt";//console.readLine();
        console.close();
        String start_tag = "tag";
        String end_tag = "/" + start_tag;
        int new_tag = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuffer bf = new StringBuffer();
            while (br.ready()) {
                String line = br.readLine();
                line=line.replaceAll("\n","");
                StringTokenizer st = new StringTokenizer(line, "<");
                while (st.hasMoreElements()) {
                    //System.out.println(st.nextElement());
                    String ln = st.nextElement().toString();
                    if (ln.startsWith(start_tag)) {
                        new_tag++;
                        bf.append("<");
                        bf.append(ln);
                    }
                    if (ln.startsWith(end_tag)) {
                        new_tag--;
                        if (new_tag == 0) {
                            bf.append("<");
                            bf.append(ln);
                            System.out.println(bf.toString());
                            bf = new StringBuffer();
                        }
                    }
                    if (!ln.startsWith(start_tag) && !ln.startsWith(end_tag) && new_tag > 0) {
                        bf.append("<");
                        bf.append(ln);
                    }
                }
            }

        }
    }
}
