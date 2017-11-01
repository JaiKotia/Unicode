package com.unicode;

public class Post {

    String name;
    String position;
    String nationality;
    int jerseyNumber;

    public Post(String name, String position, String nationality, int jerseyNumber) {
        this.name = name;
        this.position = position;
        this.nationality = nationality;
        this.jerseyNumber = jerseyNumber;
    }

    public String getName() {
        return name;
    }

    public String getPosition() { return position; }

    public String getNationality() {
        return nationality;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }
}


