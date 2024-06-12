package com.szm.pojo;

import java.util.Date;

public class Elder {
    private int id               ;
    private String name             ;
    private int gender           ;
    private int age              ;
    private Date birthday         ;
    private String emergency_contact;
    private String health_condition ;
    private String allergy_info     ;
    private String medication_info  ;
    private String remarks          ;
    private String caretaker ;
    private String bed_number;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }

    public String getHealth_condition() {
        return health_condition;
    }

    public void setHealth_condition(String health_condition) {
        this.health_condition = health_condition;
    }

    public String getAllergy_info() {
        return allergy_info;
    }

    public void setAllergy_info(String allergy_info) {
        this.allergy_info = allergy_info;
    }

    public String getMedication_info() {
        return medication_info;
    }

    public void setMedication_info(String medication_info) {
        this.medication_info = medication_info;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBed_number() {
        if(this.bed_number==null){
            return "null";
        }else{
            return bed_number;
        }
    }

    public void setBed_number(String bed_number) {
        this.bed_number = bed_number;
    }

    public String getCaretaker() {
        if(this.caretaker==null){
            return "null";
        }else{
            return caretaker;
        }
    }

    public void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public String toString() {
        return "Elder{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", emergency_contact='" + emergency_contact + '\'' +
                ", health_condition='" + health_condition + '\'' +
                ", allergy_info='" + allergy_info + '\'' +
                ", medication_info='" + medication_info + '\'' +
                ", remarks='" + remarks + '\'' +
                ", caretaker='" + caretaker + '\'' +
                ", bed_number='" + bed_number + '\'' +
                '}';
    }
}
