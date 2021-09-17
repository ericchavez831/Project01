package com.cst438.project01.group08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cst438.project01.group08.data.UserDAO;
import com.cst438.project01.group08.model.UserDataBase;
import com.cst438.project01.group08.model.User;


public class RegisterActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword, editTextCnfPassword;
    Button buttonRegister;
    private UserDAO userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = findViewById(R.id.editTextTextPersonName2);
        editTextPassword = findViewById(R.id.editTextTextPassword2);
        editTextCnfPassword = findViewById(R.id.editTextTextPassword3);
        buttonRegister = findViewById(R.id.button2);


        userDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordConf = editTextCnfPassword.getText().toString().trim();

                if (password.equals(passwordConf)) {
                    User user = new User(userName,password);
                    userDao.insert(user);
                    Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(moveToLogin);
                    finish();

                } else {
                    Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
