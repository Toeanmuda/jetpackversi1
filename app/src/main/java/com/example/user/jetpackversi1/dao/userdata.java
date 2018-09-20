package com.example.user.jetpackversi1.dao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "userdata_table")
public class userdata {




    @ColumnInfo(name = "created_at")
    public String createdAt;

    @NonNull
    @PrimaryKey
    public String userUID;


    public String userName;

    public userdata(@NonNull String userUID, String userName,Boolean checked) {
        this.userUID = userUID;
        this.userName = userName;
        this.checked = checked;
    }
    public String getUserUID() {
        return userUID;
    }
    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }


    @ColumnInfo(name = "updated_at")
    public String updatedAt;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean checked;

}

