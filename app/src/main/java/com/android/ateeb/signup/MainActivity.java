package com.android.ateeb.signup;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String username;
    TextView usernameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameTv=findViewById(R.id.username_tv);

        username=getIntent().getStringExtra("user");
        usernameTv.setText(String.valueOf("Welcome " + username));
    }
}
