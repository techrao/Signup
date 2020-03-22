package com.android.ateeb.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signupactivity extends AppCompatActivity {


    EditText usernameEt;
    EditText passwordEt;
    TextView signup_Tv;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);

        usernameEt=findViewById(R.id.username_et);
        passwordEt=findViewById(R.id.password_et);
        signup_Tv=findViewById(R.id.signup_tv);
        loginbtn=findViewById(R.id.login_btn);

        signup_Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signupactivity.this, OriginalSignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=usernameEt.getText().toString();
                String password=passwordEt.getText().toString();

                if (username.isEmpty()){
                    usernameEt.setError("Must enter username");
                    usernameEt.requestFocus();
                }
                else if (password.isEmpty()) {
                    usernameEt.setError("Must enter password");
                    usernameEt.requestFocus();
                }
                else if ((username.equals("rao") && password.equals("123"))
                        || (username.equals("ahmed") && password.equals("123"))){
                    //start main activity
                    Intent intent = new Intent(signupactivity.this, MainActivity.class);
                    intent.putExtra("user", username);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(signupactivity.this, "Incorrect username or password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
