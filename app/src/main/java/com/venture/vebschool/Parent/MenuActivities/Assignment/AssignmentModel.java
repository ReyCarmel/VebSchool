package com.venture.vebschool.Parent.MenuActivities.Assignment;

public class AssignmentModel {
    String id,sub,tit,date,desc,ref;

    public AssignmentModel(String id, String title, String description, String reference) {
        this.id=id;
        this.tit=title;
        this.desc=description;
        this.ref=reference;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public AssignmentModel(String id, String subject, String title, String date, String s) {
        this.id=id;
        this.sub=subject;
        this.tit=title;
        this.date=date;

    }
}
