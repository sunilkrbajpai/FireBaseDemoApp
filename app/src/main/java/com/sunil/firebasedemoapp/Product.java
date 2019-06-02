package com.sunil.firebasedemoapp;

public class Product {
private int image;
private String name,date;
private int age,rollNo;

public Product(){

}

    public int getImage() {
        return R.drawable.user;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getAge() {
        return age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public Product(String name, String date, int age, int rollNo) {
        this.name = name;
        this.date = date;
        this.age = age;
        this.rollNo = rollNo;
    }
}

