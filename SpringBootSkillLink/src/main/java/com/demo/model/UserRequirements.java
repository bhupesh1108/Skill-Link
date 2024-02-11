package com.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userrequirements")
public class UserRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String skills;
    private double wages;
    private String address;
    private String date;

    public UserRequirements() {
        super();
    }

    public UserRequirements(String skills, double wages, String address, String date) {
        super();
        this.skills = skills;
        this.wages = wages;
        this.address = address;
        this.date = date;
    }

    // Getters and Setters

    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    private void setUserId(int userId) {
        //this.userId = userId;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public double getWages() {
        return wages;
    }

    public void setWages(double wages) {
        this.wages = wages;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserRequirements [userId=" + userId + ", skills=" + skills + ", wages=" + wages + ", address="
                + address + ", date=" + date + "]";
    }
}