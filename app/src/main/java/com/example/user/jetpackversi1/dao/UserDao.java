package com.example.user.jetpackversi1.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.user.jetpackversi1.dao.userdata;

import java.util.List;

@Dao
public interface UserDao {

    @Query("DELETE FROM userdata_table")
    void deleteAll();

    @Delete
    void deleteitem(userdata user);

    @Query("SELECT * FROM userdata_table WHERE userName LIKE :name")
    userdata findByName(String name);


    @Query("SELECT count(*) FROM userdata_table")
    LiveData<Integer> datajumlah();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertuser(userdata user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertuser1(userdata user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<userdata> users);

    @Query("SELECT * FROM userdata_table")
    LiveData<List<userdata>> loadAll();

    @Query("UPDATE userdata_table SET userName=:username WHERE userUID = :id")
    void update(String username, String id);

    @Update
    void updatelagi(userdata user);

    @Query("SELECT * FROM userdata_table WHERE userUID IN (:userIds)")
    List<userdata> loadAllByIds(List<Integer> userIds);


}
