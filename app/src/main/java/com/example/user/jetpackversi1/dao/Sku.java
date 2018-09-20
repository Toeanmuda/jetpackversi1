package com.example.user.jetpackversi1.dao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "sku_table")
public class Sku {

    @ColumnInfo(name = "created_at")
    public String createdAt;

    @NonNull
    public String getSkuSid() {
        return skuSid;
    }

    public void setSkuSid(@NonNull String skuSid) {
        this.skuSid = skuSid;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuGroup() {
        return skuGroup;
    }

    public void setSkuGroup(String skuGroup) {
        this.skuGroup = skuGroup;
    }

    public String getSkuType() {
        return skuType;
    }

    public void setSkuType(String skuType) {
        this.skuType = skuType;
    }

    @NonNull
    @PrimaryKey
    public String skuSid;

    public String skuName;
    public String skuGroup;
    public String skuType;

    @ColumnInfo(name = "updated_at")
    public String updatedAt;
}


