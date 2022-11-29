package com.homework.homeWork9;

public class AppMyList extends MyList{

    static MyList name;
    static MyList nameN;


    public static void main(String[] args) {

        name = new MyList();
        nameN = new MyList();

        name.add(0,"Ann");
        name.add(1,"Ben");
        name.add(2, "Ken");
        name.add("Len");

        System.out.println(name.size());
        name.showMyList();


        System.out.println(name.get(2));
        name.delete("Ann");
        name.showMyList();
        name.delete(0);
        name.showMyList();


        //nameN.addAll(name);
        //nameN.showMyList();

        //System.out.println(nameN.size());



    }
}
