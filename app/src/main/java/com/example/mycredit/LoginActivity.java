package com.example.mycredit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycredit.database.DBHelper;

public class LoginActivity extends AppCompatActivity {
    private EditText loginUsername, loginPass;
    private Button btnLogin, btnSignUp;
    private DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginUsername = findViewById(R.id.signupemail);
        loginPass = findViewById(R.id.siguppassword);
        btnLogin = findViewById(R.id.loginbutton);
        btnSignUp = findViewById(R.id.signUpbutton);


        myDB = new DBHelper(this);
        loginUser();
    }

    private void loginUser(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var = myDB.checkUser(loginUsername.getText().toString(), loginPass.getText().toString());
                if (var){
                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void signUp(View v) {
        switch (v.getId()) {
            case R.id.signUpbutton:
                Intent intent = new Intent(this, SignUpActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}