package com.venture.vebschool.model;

public class StudentModel {
    String id,admission_no,name,s_class,division,roll_no,email,gender,birthday,phone_no;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getS_class() {
        return s_class;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getAdmission_no() {
        return admission_no;
    }

    public void setAdmission_no(String admission_no) {
        this.admission_no = admission_no;
    }

    public StudentModel(String id, String admission_no, String name, String s_class, String division, String roll_no, String email, String gender, String birthday, String phone_no) {
        this.id = id;
        this.admission_no=admission_no;
        this.name = name;
        this.s_class = s_class;
        this.division = division;
        this.roll_no = roll_no;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.phone_no = phone_no;
    }

}
