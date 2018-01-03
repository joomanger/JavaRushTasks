package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter  {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        //super(fileName);
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
       // super(fileName, append);
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
       // super(file);
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
       // super(file, append);
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
       // super(fd);
        fileWriter = new FileWriter(fd);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        //fileWriter.write();
        System.out.println(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.println(new String(cbuf, off, len));
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        if (len < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            char[] var4 = new char[len];
            str.getChars(off, off + len, var4, 0);
            //this.write((char[]) var4, 0, len);
            System.out.println(new String((char[]) var4, 0, len));
        }
        //System.out.println();
    }

    public void close() throws IOException {
        //super.close();
        fileWriter.close();
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(new String(cbuf));
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public static void main(String[] args) {

    }

}
