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

public class SignUpActivity extends AppCompatActivity {

    private EditText emailSignUp , usernameSignUp , passwordSignUp;
    private Button signUpButton, btn;
    private DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailSignUp = findViewById(R.id.signupemail);
        usernameSignUp = findViewById(R.id.signupusername);
        passwordSignUp = findViewById(R.id.siguppassword);

        signUpButton = findViewById(R.id.signupbutton);
        btn = findViewById(R.id.signupbutton);

        myDB = new DBHelper(this);
        btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String getEmail = emailSignUp.getText().toString();
            String getUsername = usernameSignUp.getText().toString();
            String getPassword = passwordSignUp.getText().toString();

            //Validation
            if (getUsername.isEmpty()) {
                usernameSignUp.setError("Please Fill Your Username");
            } else if (getEmail.isEmpty()) {
                emailSignUp.setError("Please Fill Your Email");
            } else if (getPassword.isEmpty()) {
                passwordSignUp.setError("Please Fill Your Password");
            } else {
                boolean var = myDB.registerUser(getUsername, getEmail, getPassword);
                if (var) {
                    Toast.makeText(SignUpActivity.this, "User Registered Successfully !!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                } else
                    Toast.makeText(SignUpActivity.this, "Registration Error !!", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }
}