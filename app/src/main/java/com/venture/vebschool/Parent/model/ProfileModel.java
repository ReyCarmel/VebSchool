package com.venture.vebschool.Parent.model;

 public class ProfileModel {
     String id,na,ge,em,ad,ph;

     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }

     public String getNa() {
         return na;
     }

     public void setNa(String na) {
         this.na = na;
     }

     public String getGe() {
         return ge;
     }

     public void setGe(String ge) {
         this.ge = ge;
     }

     public String getEm() {
         return em;
     }

     public void setEm(String em) {
         this.em = em;
     }

     public String getAd() {
         return ad;
     }

     public void setAd(String ad) {
         this.ad = ad;
     }

     public String getPh() {
         return ph;
     }

     public void setPh(String ph) {
         this.ph = ph;
     }

     public ProfileModel(String id, String name, String gender, String email, String address, String phone) {
         this.id=id;
         this.na=name;
         this.ge=gender;
         this.ad=address;
         this.em=email;
         this.ph=phone;
     }
 }
