package com.venture.vebschool.model;

public class Exam {
    String name;
    String id;
    String sdate,endate;

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEndate() {
        return endate;
    }

    public void setEndate(String endate) {
        this.endate = endate;
    }

    public Exam(String id, String s_date, String end_date, String e_name) {
        this.id=id;
        this.sdate=s_date;
        this.endate=end_date;
        this.name=e_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Exam(String name, String id) {
        this.name = name;
        this.id = id;
    }


}
