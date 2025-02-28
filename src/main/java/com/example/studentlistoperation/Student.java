package com.example.studentlistoperation;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate dob;
    private String major;
    private String password;
    private String gender;

    // Constructor with all fields
    public Student(int id, String name, LocalDate dob, String major, String password, String gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.major = major;
        this.password = password;
        this.gender = gender;
    }

    // Default constructor
    public Student() {
        this.id = 0;
        this.name = "";
        this.dob = null;
        this.major = "";
        this.password = "";
        this.gender = "";
    }

    // Getters and Setters
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Override toString() for debugging purposes
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", major='" + major + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}