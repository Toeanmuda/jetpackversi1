package com.example.user.jetpackversi1.data.model;

import android.databinding.BaseObservable;

import java.util.List;

public class UserModel extends BaseObservable {

    private String userName;
    private String password;
    private String imeiNumber;

    private String userUID;
    private String authorization;
    private Status status;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImeiNumber() {
        return imeiNumber;
    }

    public void setImeiNumber(String imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

    public UserModel()
    {

    }
        public UserModel(String paramString1, String paramString2,String paramString3)
        {
            userName = paramString1;
            password = paramString2;
            imeiNumber= paramString3;
        }
}
