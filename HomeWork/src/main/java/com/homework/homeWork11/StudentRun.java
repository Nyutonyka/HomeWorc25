package com.homework.homeWork11;

public class StudentRun {

    public static void main(String[] args) {

        Student st = new Student();
        st.setId(1);
        st.setName("Ann");
        st.setLastName("Daniel");
        st.setAge(21);

        System.out.println(st);

        //можно сократить создание класса до одной строчки
        //с помощью @Accessors(chain = true)

        Student stA = new Student()
                .setId(2).setName("Ann").setLastName("Daniel").setAge(25);

        System.out.println(stA);

        System.out.println(st.equals(stA));
    }
}
