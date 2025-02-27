package com.example.studentlistoperation;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private LocalDate dob;
    private String major;
    private String password;
    private Gender gender;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public Student(int id, String name, LocalDate dob, String major, String password, Gender gender) {
        setId(id);
        setName(name);
        setDob(dob);
        setMajor(major);
        setPassword(password);
        setGender(gender);
    }

    public Student() {
        this.id = 0;
        this.name = null;
        this.dob = null;
        this.major = "tba";
        this.password = null;
        this.gender = Gender.OTHER;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        if (dob == null || dob.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be null or in the future");
        }
        this.dob = dob;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password); // Implement a hashing function
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getMajor() {
        return major;
    }

    public String getPassword() {
        return password;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", major='" + major + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private String hashPassword(String password) {
        // Implement a secure hashing algorithm here
        return password; // Placeholder, replace with actual hashing logic
    }
}