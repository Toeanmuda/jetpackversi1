package com.example.user.jetpackversi1.data.model;

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