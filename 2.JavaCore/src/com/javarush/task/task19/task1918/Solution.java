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
        String fileName = "c:/apps/test.txt";
                //console.readLine();
        console.close();

        int new_tag = 0;
        StringBuffer sbb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                sbb.append(br.readLine());
            }
        }

        String tag ="span";// args[0];
        StringBuffer bf = new StringBuffer();
        String start_tag1 = tag + " ";
        String start_tag2 = tag + ">";
        String end_tag = "/" + tag + ">";
        String line = sbb.toString();
        StringTokenizer st = new StringTokenizer(line, "<");
        while (st.hasMoreElements()) {
            String ln = st.nextElement().toString();
            if (ln.startsWith(start_tag1) || ln.startsWith(start_tag2)) {
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
                    bf.delete(0, bf.capacity());
                    //bf = new StringBuffer();
                } else {
                    bf.append("<");
                    bf.append(ln);
                }
            }
            if (!ln.startsWith(start_tag1) && !ln.startsWith(start_tag2) && !ln.startsWith(end_tag) && new_tag > 0) {
                bf.append("<");
                bf.append(ln);
            }
        }
    }
}
