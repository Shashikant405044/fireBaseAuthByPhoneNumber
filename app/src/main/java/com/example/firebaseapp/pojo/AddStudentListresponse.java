package com.example.firebaseapp.pojo;

import com.google.firebase.database.IgnoreExtraProperties;
@IgnoreExtraProperties

public class AddStudentListresponse{
   private String name_student;
     private  String regNo_student;
   private String mobileNo_student;
   private String emailNo;


    public String getName_student(String string) {
        return name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }

    public String getRegNo_student(String string) {
        return regNo_student;
    }

    public void setRegNo_student(String regNo_student) {
        this.regNo_student = regNo_student;
    }

    public String getMobileNo_student(String string) {
        return mobileNo_student;
    }

    public void setMobileNo_student(String mobileNo_student) {
        this.mobileNo_student = mobileNo_student;
    }

    public String getEmailNo(String string) {
        return emailNo;
    }

    public void setEmailNo(String emailNo) {
        this.emailNo = emailNo;
    }
}
