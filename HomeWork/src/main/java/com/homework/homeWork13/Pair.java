package com.homework.homeWork13;

public class Pair {

    private String lCase;
    private String uCase;

    public Pair(String lCase, String uCase) {
        this.lCase = lCase;
        this.uCase = uCase;
    }

    public Pair() {

    }

    public String getlCase() {
        return lCase;
    }

    public void setlCase(String lCase) {
        this.lCase = lCase;
    }

    public String getuCase() {
        return uCase;
    }

    public void setuCase(String uCase) {
        this.uCase = uCase;
    }

    @Override
    public String toString() {
        return "{" +  lCase + " : "  + uCase + '}';
    }
}
