package com.example.user.jetpackversi1.data.model;

import android.databinding.BaseObservable;

public class User extends BaseObservable {

    private String userName;
    private String password;
    private String imeiNumber;

    private String userUID;
    private String authorization;
    private Status status;
    public final class Status {
        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        private String login;
        private int loginType;
        private String serverTime;
        private String message;

        public int getLoginType() {
            return loginType;
        }

        public void setLoginType(int loginType) {
            this.loginType = loginType;
        }

        public String getServerTime() {
            return serverTime;
        }

        public void setServerTime(String serverTime) {
            this.serverTime = serverTime;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Status(String login, int loginType, String serverTime, String message) {
            super();
            this.login = login;
            this.loginType = loginType;
            this.serverTime = serverTime;
            this.message = message;
        }
    }

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

    public User()
    {

    }
        public User(String paramString1, String paramString2, String paramString3)
        {
            userName = paramString1;
            password = paramString2;
            imeiNumber= paramString3;
        }
}
