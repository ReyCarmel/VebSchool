package com.venture.vebschool.Parent.MenuActivities.Attendance;

public class AttendanceModel {
    String id,date,status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AttendanceModel(String id, String a_date, String status) {
        this.id=id;
        this.date=a_date;
        this.status=status;
    }
}
