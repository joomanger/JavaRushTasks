package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private String patronymic;
        private String surname;
        private byte age;
        private Object cat;
        private String dogName;

        public Human() {
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, String patronymic) {
            this.name = name;
            this.patronymic = patronymic;
        }

        public Human(String name, String patronymic, String surname) {
            this.name = name;
            this.patronymic = patronymic;
            this.surname = surname;
        }

        public Human(byte age) {
            this.age = age;
        }

        public Human(Object cat) {
            this.cat = cat;
        }

        public Human(String name, String patronymic, String surname, byte age, Object cat, String dogName) {
            this.name = name;
            this.patronymic = patronymic;
            this.surname = surname;
            this.age = age;
            this.cat = cat;
            this.dogName = dogName;
        }

        public Human(String name, String patronymic, String surname, byte age, Object cat) {
            this.name = name;
            this.patronymic = patronymic;
            this.surname = surname;
            this.age = age;
            this.cat = cat;
        }

        public Human(String surname, byte age, Object cat, String dogName) {
            this.surname = surname;
            this.age = age;
            this.cat = cat;
            this.dogName = dogName;
        }

        public Human(Object cat, String dogName) {
            this.cat = cat;
            this.dogName = dogName;
        }
    }
}
