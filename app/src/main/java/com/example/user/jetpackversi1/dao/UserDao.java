/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.example.user.jetpackversi1.dao;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by amitshekhar on 07/07/17.
 */

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
