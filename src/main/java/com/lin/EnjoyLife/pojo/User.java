package com.lin.EnjoyLife.pojo;

import java.sql.Date;

public class User {
    private String UserId;
    private String Password;
    private String UserName;
    private Date RegisterTime;
    private String RealName;
    private String Sex;
    private Integer Age;
    private String IdentityNumber;
    private String Tel;
    private String Email;
    private String Address;
    private String Education;
    private String Profession;
    private String Question;
    private String Answer;
    private Integer UState;
    private Integer ULevel;
    private Integer Balance;

    public User() {
    }

    public User(String userId, String password, String userName, Date registerTime, String realName, String sex, Integer age, String identityNumber, String tel, String email, String address, String education, String profession, String question, String answer, Integer UState, Integer ULevel, Integer balance) {
        UserId = userId;
        Password = password;
        UserName = userName;
        RegisterTime = registerTime;
        RealName = realName;
        Sex = sex;
        Age = age;
        IdentityNumber = identityNumber;
        Tel = tel;
        Email = email;
        Address = address;
        Education = education;
        Profession = profession;
        Question = question;
        Answer = answer;
        this.UState = UState;
        this.ULevel = ULevel;
        Balance = balance;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Date getRegisterTime() {
        return RegisterTime;
    }

    public void setRegisterTime(Date registerTime) {
        RegisterTime = registerTime;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getIdentityNumber() {
        return IdentityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        IdentityNumber = identityNumber;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public Integer getUState() {
        return UState;
    }

    public void setUState(Integer UState) {
        this.UState = UState;
    }

    public Integer getULevel() {
        return ULevel;
    }

    public void setULevel(Integer ULevel) {
        this.ULevel = ULevel;
    }

    public Integer getBalance() {
        return Balance;
    }

    public void setBalance(Integer balance) {
        Balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId='" + UserId + '\'' +
                ", Password='" + Password + '\'' +
                ", UserName='" + UserName + '\'' +
                ", RegisterTime=" + RegisterTime +
                ", RealName='" + RealName + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Age=" + Age +
                ", IdentityNumber='" + IdentityNumber + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                ", Education='" + Education + '\'' +
                ", Profession='" + Profession + '\'' +
                ", Question='" + Question + '\'' +
                ", Answer='" + Answer + '\'' +
                ", UState=" + UState +
                ", ULevel=" + ULevel +
                ", Balance=" + Balance +
                '}';
    }
}
