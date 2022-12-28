package com.example.wagba01;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoClass {


    @Insert
    void insertAllData(UserModel userModel);

    @Query("SELECT * from user ORDER BY `key` ASC")
    List<UserModel> getAllData();



}
