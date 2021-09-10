package com.cst438.project01.group08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.cst438.project01.group08.data.UserDAO;
import com.cst438.project01.group08.data.UserDataBase;

public class LoginActivity extends AppCompatActivity {

    UserDAO db;
    UserDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        dataBase = Room.databaseBuilder(this, UserDataBase.class, "User")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDAO();

    }
}