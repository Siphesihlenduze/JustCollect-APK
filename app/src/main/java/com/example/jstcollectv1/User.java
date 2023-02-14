package com.example.jstcollectv1;

public class User {

    private String name;
    private String desc;
    private String cat;
    private String goal;
    private String date;

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User(String name, String desc, String cat, String goal, String date) {
        this.name = name;
        this.desc = desc;
        this.cat = cat;
        this.goal = goal;
        this.date = date;

    }



}
