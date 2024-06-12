package com.szm.pojo;

public class Bed {

    private int id         ;
    private String location   ;
    private int flag       ;
    private String elder_name ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getElder_name() {
        return elder_name;
    }

    public void setElder_name(String elder_name) {
        this.elder_name = elder_name;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", flag=" + flag +
                ", elder_name='" + elder_name + '\'' +
                '}';
    }
}
