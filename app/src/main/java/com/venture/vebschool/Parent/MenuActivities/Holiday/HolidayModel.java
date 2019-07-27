package com.venture.vebschool.Parent.MenuActivities.Holiday;

public class HolidayModel {
    String ID,name,date;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HolidayModel(String id, String h_name, String h_date) {
        this.ID=id;
        this.name=h_name;
        this.date=h_date;
    }


}
