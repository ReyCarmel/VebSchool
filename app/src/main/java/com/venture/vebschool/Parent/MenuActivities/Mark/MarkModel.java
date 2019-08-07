package com.venture.vebschool.Parent.MenuActivities.Mark;

public  class MarkModel {
    String id,subject,mark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public MarkModel(String id, String subject, String mark)
    {
        this.id=id;
        this.subject=subject;
        this.mark=mark;
    }
}
