package com.example.firebaseapp.pojo;

public class StudentResponse {

    private String BatchName;
    private String BatchSubject;

    public String getBatchName() {
        return BatchName;
    }

    public void setBatchName(String batchName) {
        BatchName = batchName;
    }

    public String getBatchSubject() {
        return BatchSubject;
    }

    public void setBatchSubject(String batchSubject) {
        BatchSubject = batchSubject;
    }
}
