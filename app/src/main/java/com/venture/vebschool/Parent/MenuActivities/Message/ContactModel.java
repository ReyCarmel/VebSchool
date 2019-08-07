package com.venture.vebschool.Parent.MenuActivities.Message;

public class ContactModel {
    String id,name,sub;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public ContactModel(String id, String c_name, String subject) {
        this.id=id;
        this.name=c_name;
        this.sub=subject;
    }

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

    public ContactModel(String id, String c_contact) {
        this.id=id;
        this.name=c_contact;
    }
}
