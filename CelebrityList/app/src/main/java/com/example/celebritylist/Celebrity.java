package com.example.celebritylist;

public class Celebrity {

    private String fName, lName, profession;
    private int age;
    private double netWorth;


    public Celebrity (String fName, String lName, String profession, int age, double netWorth){

    this.fName = fName;
    this.lName = lName;
    this.profession =profession;
    this.age = age;
    this.netWorth = netWorth;

    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }
}


