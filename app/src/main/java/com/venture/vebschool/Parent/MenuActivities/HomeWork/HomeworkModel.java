package com.venture.vebschool.Parent.MenuActivities.HomeWork;

public class HomeworkModel {
    String id,title,desc,date,reference,attach;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public HomeworkModel(String id, String title, String description, String h_ref, String h_attach) {
        this.id=id;
        this.title=title;
        this.desc=description;
        this.reference=h_ref;
        this.attach=h_attach;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HomeworkModel(String id, String title, String description, String h_date) {
        this.id=id;
        this.title=title;
        this.desc=description;
        this.date=h_date;
    }
}
