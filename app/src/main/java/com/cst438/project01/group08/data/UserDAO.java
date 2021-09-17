package com.cst438.project01.group08.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cst438.project01.group08.model.User;


@Dao
public interface UserDAO {
    @Query("SELECT * FROM User where userName= :userName and password= :password")
    User getUser(String userName, String password);

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
