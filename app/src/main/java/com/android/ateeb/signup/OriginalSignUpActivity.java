package com.android.ateeb.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import android.content.Intent;
import android.widget.TextView;

public class OriginalSignUpActivity extends AppCompatActivity {

    EditText signup_username_ET, signup_email_ET, signup_password_ET, signup_confirm_password_ET;
    Button signup_btn;
    AwesomeValidation awesomeValidation;
    TextView signup_login_Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_original_sign_up);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        updateUI();
    };

    private void updateUI() {

        signup_username_ET =(EditText)findViewById(R.id.signup_username_et);
        signup_email_ET =(EditText)findViewById(R.id.signup_email_et);
        signup_password_ET =(EditText)findViewById(R.id.signup_password_et);
        signup_confirm_password_ET =(EditText)findViewById(R.id.signup_confirm_password_et);
        signup_btn =(Button)findViewById(R.id.signup_btn);
        signup_login_Tv=findViewById(R.id.signup_login_tv);

        String regexPassword = "^(?=.*[a-z]).{6,}$";
        awesomeValidation.addValidation(OriginalSignUpActivity.this,R.id.signup_username_et, "[a-zA-Z\\s]+",R.string.fnameerr);
        awesomeValidation.addValidation(OriginalSignUpActivity.this,R.id.signup_email_et,android.util.Patterns.EMAIL_ADDRESS,R.string.emailerr);
        awesomeValidation.addValidation(OriginalSignUpActivity.this,R.id.signup_password_et,regexPassword,R.string.passerr);
        awesomeValidation.addValidation(OriginalSignUpActivity.this,R.id.signup_confirm_password_et,R.id.signup_password_et,R.string.cnfpasserr);


        signup_login_Tv.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(OriginalSignUpActivity.this, signupactivity.class);
                  startActivity(intent);
                  finish();
              }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String signupusername=signup_username_ET.getText().toString();

                if (awesomeValidation.validate()){

                    Intent intent = new Intent(OriginalSignUpActivity.this, MainActivity.class);
                    intent.putExtra("user", signupusername);
                    startActivity(intent);
                    finish();                }

                else

                {
                    Toast.makeText(OriginalSignUpActivity.this, "Incorrect username or password", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
