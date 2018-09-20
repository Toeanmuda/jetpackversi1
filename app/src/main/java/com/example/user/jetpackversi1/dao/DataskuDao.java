package com.example.user.jetpackversi1.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface DataskuDao {

    @Query("SELECT * FROM datasku_table")
    LiveData<List<Datasku>> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertuser(Datasku datasku);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMultipleMovies (List<Datasku> dataskus);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updatelagi(Datasku datasku);
//when use checked
    @Query("SELECT * FROM datasku_table WHERE trcSid = :trcSid")
    Datasku getState(String trcSid);

    @Query("UPDATE datasku_table SET checked=:nilai WHERE trcSid = :id")
    void update_checked(Boolean nilai, String id);


}
