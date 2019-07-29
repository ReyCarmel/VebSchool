package com.venture.vebschool.Parent.MenuActivities.Leave;

public class LeaveModel {

    String id;
    String date;
    String reason;
    String status;
    String desc;
    String sub;

    public LeaveModel(String id, String l_date, String subject, String description) {
        this.id=id;
        this.date=l_date;
        this.sub=subject;
        this.desc=description;

    }


    public String getDescription() {
        return desc;
    }

    public void setDescription(String description) {
        this.desc = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }



    String subject;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LeaveModel(String id, String l_date, String reason, String status,String abc) {
        this.id=id;
        this.date=l_date;
        this.reason=reason;
        this.status=status;
    }
}
