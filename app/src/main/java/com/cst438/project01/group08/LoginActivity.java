package com.cst438.project01.group08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.os.Bundle;
import com.cst438.project01.group08.data.UserDAO;
import com.cst438.project01.group08.model.UserDataBase;
import com.cst438.project01.group08.model.User;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * <h2><b>Login Activity</b></h2>
 * The login activity contains the functionality to login a user to the application user a database.
 *
 * @author Cristina Martinez
 */

public class LoginActivity extends AppCompatActivity {
    EditText mUsername, mPassword;
    Button buttonLogin;
    TextView registerTextView;
    UserDAO db;
    UserDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mUsername = findViewById(R.id.etUsername);
        mPassword = findViewById(R.id.etPassword);
        buttonLogin = findViewById(R.id.btnLogin);
        registerTextView = findViewById(R.id.tvRegister);

        dataBase = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                Boolean empty = emptyAccount(userName, password);

                if(empty){
                    Toast.makeText(LoginActivity.this, "Empty Field(s)", Toast.LENGTH_SHORT).show();
                    return;
                }

                User user = db.getUser(userName, password);
                if (user != null) {
                    Intent i = new Intent(LoginActivity.this, DisplayActivity.class);
                    i.putExtra("User", user);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }

    public boolean emptyAccount(String username, String password){
        if(username.length() == 0 || password.length() == 0){
            return true;
        }

        return false;
    }
}