package com.szm.pojo;

import javax.xml.crypto.Data;

public class Caretaker {
    private int id        ;
    private String name      ;
    private int gender    ;
    private int age       ;
    private Data birthday  ;
    private String phone     ;
    private String remarks   ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Data getBirthday() {
        return birthday;
    }

    public void setBirthday(Data birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Caretaker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
