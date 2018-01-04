package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("test", null);
            System.out.println(your_file_name.getAbsolutePath());
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user1 = new User();
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

            String ds1 = "12-JAN-1981";
            user1.setBirthDate(df.parse(ds1));
            user1.setCountry(User.Country.UKRAINE);
            user1.setFirstName("Alex1");
            user1.setLastName("Last1");
            user1.setMale(Boolean.TRUE);
            User user2 = new User();
            String ds2 = "10-JAN-1911";
            user2.setBirthDate(df.parse(ds2));
            user2.setCountry(User.Country.OTHER);
            user2.setFirstName("Alex2");
            user2.setLastName("Last2");
            user2.setMale(Boolean.TRUE);
            User user3 = new User();
            String ds3 = "01-FEB-1990";
            user3.setBirthDate(df.parse(ds3));
            user3.setCountry(User.Country.RUSSIA);
            user3.setFirstName("Alex3");
            user3.setLastName("Last3");
            user3.setMale(Boolean.TRUE);

            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

//            for (User user : javaRush.users) {
//                System.out.println(user.getBirthDate().toString() + user.getCountry() + user.getFirstName() + user.getLastName()
//                        + user.isMale());
//            }
//            System.out.println();
//
//            for (User user : loadedObject.users) {
//                System.out.println(user.getBirthDate().toString() + user.getCountry() + user.getFirstName() + user.getLastName() + user.isMale());
//            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (User user : users) {
                printWriter.print(user.getFirstName());
                printWriter.print("\u0009");
                printWriter.print(user.getLastName());
                printWriter.print("\u0009");
                printWriter.print(user.getBirthDate().getTime());
                printWriter.print("\u0009");
                printWriter.print(user.getCountry());
                printWriter.print("\u0009");
                printWriter.println(user.isMale());
            }
            printWriter.flush();
            printWriter.close();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                while (br.ready()) {
                    String line = br.readLine();
                    StringTokenizer st = new StringTokenizer(line, "\u0009");
                    User user = new User();
                    user.setFirstName(st.nextElement().toString());
                    user.setLastName(st.nextElement().toString());
                    Long dt = Long.parseLong(st.nextElement().toString());
                    user.setBirthDate(new Date(dt));
                    user.setCountry(User.Country.valueOf(st.nextElement().toString()));
                    user.setMale(Boolean.valueOf(st.nextElement().toString()));
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
