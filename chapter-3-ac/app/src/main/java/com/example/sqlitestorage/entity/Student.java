package com.example.sqlitestorage.entity;

public class Student {

    private String username;
    private String phone;

    public Student(){}

    public Student(String username, String phone) {
        this.username = username;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
