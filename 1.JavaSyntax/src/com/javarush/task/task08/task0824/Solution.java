package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandfather1 = new Human();
        grandfather1.age = 90;
        grandfather1.name = "Ded1";
        grandfather1.sex = true;
        Human grandfather2 = new Human();
        grandfather2.age = 80;
        grandfather2.name = "Ded2";
        grandfather2.sex = true;

        Human grandmother1 = new Human();
        grandmother1.age = 90;
        grandmother1.name = "Babka1";
        grandmother1.sex = false;
        Human grandmother2 = new Human();
        grandmother2.age = 88;
        grandmother2.name = "Babka2";
        grandmother2.sex = false;

        Human father = new Human();
        father.age = 50;
        father.name = "father";
        father.sex = true;
        Human mother = new Human();
        mother.age = 40;
        mother.name = "mother";
        mother.sex = false;

        Human child1 = new Human();
        child1.age = 19;
        child1.name = "child1";
        child1.sex = true;
        Human child2 = new Human();
        child2.age = 12;
        child2.name = "child2";
        child2.sex = true;
        Human child3 = new Human();
        child3.age = 10;
        child3.name = "child3";
        child3.sex = false;

        List<Human> c1 = new ArrayList<>();
        c1.add(father);
        List<Human> c2 = new ArrayList<>();
        c2.add(mother);
        List<Human> c3 = new ArrayList<>();
        c3.add(child1);
        c3.add(child2);
        c3.add(child3);

        grandfather1.children = c1;
        grandmother1.children = c1;
        grandfather2.children = c2;
        grandmother2.children = c2;
        father.children = c3;
        mother.children = c3;

        System.out.println(grandfather1);
        System.out.println(grandmother1);
        System.out.println(grandfather2);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        List<Human> children = new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
