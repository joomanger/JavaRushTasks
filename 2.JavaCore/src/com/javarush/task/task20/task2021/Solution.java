package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException("Не сегодня!");
        }

        private void readObject(ObjectInputStream in) throws IOException {
            throw new NotSerializableException("Не сегодня!");
        }
    }

    public static void main(String[] args) throws Exception {
//        FileOutputStream fileOutput = new FileOutputStream("c:\\apps\\test.txt");
//        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
//
//        Solution solution = new Solution();
//        SubSolution ss = new SubSolution();
//        outputStream.writeObject(ss);
//
//        fileOutput.close();
//        outputStream.close();
//
//        //loading
//        FileInputStream fiStream = new FileInputStream("c:\\apps\\test.txt");
//        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
//
//        SubSolution loadedObject = (SubSolution) objectStream.readObject();
//
//        fiStream.close();
//        objectStream.close();

        //Attention!!
        //System.out.println(loadedObject.size());
    }
}
