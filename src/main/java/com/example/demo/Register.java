package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userId;

    @Column(name = "usernickname")
    private String userNickName;

    @Column(name = "userpassword")
    private String userPassword;

    @Column(name = "usermail")
    private String userMail;

    @Column(name = "username")
    private String userName;

    @Column(name = "usersurname")
    private String userSurname;

    @Column(name = "country")
    private String Country;

    @Column(name = "city")
    private String City;

    public Register() {
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String contry) {
        Country = contry;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return "Register{" +
                "userId=" + userId +
                ", userNickName='" + userNickName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", Country='" + Country + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}
