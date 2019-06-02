package com.sunil.firebasedemoapp;

public class SaveData {
    String name,date;
    int age,rollNo;
    public SaveData(){}

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

    public SaveData(String Name, String Date, int Age, int RollNo) {
        name = Name;
        date = Date;
        age = Age;
        rollNo = RollNo;
    }
}
