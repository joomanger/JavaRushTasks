package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    private static void fillList(List<String> list, String fullFilePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(fullFilePath)));
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String file1=scanner.nextLine();
        String file2=scanner.nextLine();
        scanner.close();

        try {
            fillList(allLines, file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fillList(forRemoveLines, file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Solution s = new Solution();
        try {
            s.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public  void joinData() throws CorruptedDataException {
        for (String al : forRemoveLines) {
            if (!allLines.contains(al)) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
        for (String al : forRemoveLines) {
            allLines.remove(al);
        }
    }
}
