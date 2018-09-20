package com.example.user.jetpackversi1.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.user.jetpackversi1.dao.Sku;

import java.util.List;

@Dao
public interface SkuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMultipleMovies(List<Sku> skus);

    @Query("SELECT skuName FROM sku_table WHERE skuSid=:skuSid")
    String getSkuName(String skuSid);
}
