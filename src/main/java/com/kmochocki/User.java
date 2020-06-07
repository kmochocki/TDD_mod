package com.kmochocki;

public class User {

    private final int id;
    private final String imie;

    public User(int id, String imie) {
        this.id = id;
        this.imie = imie;
    }

    public String getImie() {
        return imie;
    }

    public int getId() {
        return id;
    }
}
