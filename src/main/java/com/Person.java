package com;

/**
 * Created by masy on 2016/3/17.
 */
public class Person {
    private int age;
    private String sex;

    public Person() {
        int random = (int) (1 + Math.random() * (2 - 1 + 1));
        if (random == 1) {
            sex = "M";
        } else {
            sex = "F";
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
