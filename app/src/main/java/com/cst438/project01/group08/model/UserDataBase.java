package com.cst438.project01.group08.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cst438.project01.group08.data.UserDAO;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {

    public abstract UserDAO getUserDao();

}

