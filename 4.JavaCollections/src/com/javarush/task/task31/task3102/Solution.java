package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            for (File s : (new File(queue.poll())).listFiles()) {
                if (s.isFile())
                    list.add(s.getAbsolutePath());
                else
                    queue.add(s.getAbsolutePath());
            }
        }
        return list;

    }

    public static void main(String[] args) throws Exception {
        List<String> list = getFileTree("/Work/files");
        list.stream().forEach(m -> System.out.println(m));
    }
}
