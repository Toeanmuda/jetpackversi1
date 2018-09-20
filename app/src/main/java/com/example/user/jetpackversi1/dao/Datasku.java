package com.example.user.jetpackversi1.dao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.widget.TextView;

@Entity(tableName = "datasku_table")
public class Datasku {

    @ColumnInfo(name = "created_at")
    public String createdAt;

    @NonNull
    @PrimaryKey
    public String trcSid;

    public int trcType;
    public int coType;
    public String ptSid;
    public String skuSid;
    public  String skuUnit;
    public int pckg;
    public int trcQty;
    public int trcAccept;
    public Boolean isSync;
    public String postDate;
    @ColumnInfo(name = "updated_at")
    public String updatedAt;
    @Nullable
    public Boolean checked;

    /*
    public Datasku(@NonNull String trcSid, int trcType, int coType, String ptSid, String skuSid, String skuUnit, int pckg, int trcQty, int trcAccept, Boolean isSync, String postDate) {
        this.trcSid = trcSid;
        this.trcType = trcType;
        this.coType = coType;
        this.ptSid = ptSid;
        this.skuSid = skuSid;
        this.skuUnit = skuUnit;
        this.pckg = pckg;
        this.trcQty = trcQty;
        this.trcAccept = trcAccept;
        this.isSync = isSync;
        this.postDate = postDate;
    }
*/

    @NonNull
    public String getTrcSid() {
        return trcSid;
    }

    public void setTrcSid(@NonNull String trcSid) {
        this.trcSid = trcSid;
    }

    public int getTrcType() {
        return trcType;
    }

    public void setTrcType(int trcType) {
        this.trcType = trcType;
    }

    public int getCoType() {
        return coType;
    }

    public void setCoType(int coType) {
        this.coType = coType;
    }

    public String getPtSid() {
        return ptSid;
    }

    public void setPtSid(String ptSid) {
        this.ptSid = ptSid;
    }

    public String getSkuSid() {
            return skuSid;
    }
    public void setSkuSid(String skuSid) {
        this.skuSid = skuSid;
    }

    public String getSkuUnit() {
        return skuUnit;
    }

    public void setSkuUnit(String skuUnit) {
        this.skuUnit = skuUnit;
    }

    public int getPckg() {
        return pckg;
    }

    public void setPckg(int pckg) {
        this.pckg = pckg;
    }

    public int getTrcQty() {
        return trcQty;
    }

    public void setTrcQty(int trcQty) {
        this.trcQty = trcQty;
    }

    public int getTrcAccept() {
        return trcAccept;
    }

    public void setTrcAccept(int trcAccept) {
        this.trcAccept = trcAccept;
    }

    public Boolean getSync() {
        return isSync;
    }

    public void setSync(Boolean sync) {
        isSync = sync;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }


}


