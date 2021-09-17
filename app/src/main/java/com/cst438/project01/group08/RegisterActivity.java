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

/**
 *
 * <h2><b>RegisterActivity</b></h2>
 * The register activity contains the functionality to register a user to application.
 *
 * @author Cristina Martinez
 */

public class RegisterActivity extends AppCompatActivity {
    EditText mUsername, mPassword, mPasswordConfirm;
    Button buttonRegister;
    TextView loginTextView;
    private UserDAO userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUsername = findViewById(R.id.etUsername);
        mPassword = findViewById(R.id.etPassword);
        mPasswordConfirm = findViewById(R.id.etPasswordConfirm);
        buttonRegister = findViewById(R.id.btnRegister);
        loginTextView = findViewById(R.id.tvLogin);

        userDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String passwordConf = mPasswordConfirm.getText().toString().trim();
                boolean empty;

                empty = emptyFields(userName, password, passwordConf);

                if(!empty){
                    if (password.equals(passwordConf)) {
                        User user = new User(userName,password);
                        userDao.insert(user);
                        Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(moveToLogin);
                        finish();

                    } else {
                        Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Empty Field(s)", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public boolean emptyFields(String username, String password, String passwordConfirm){

        if(username.length() == 0 || password.length() == 0 || passwordConfirm.length() == 0){
            return true;
        }

        return false;
    }
}
