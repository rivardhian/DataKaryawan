package com.example.datakaryawan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class halamanlogin extends AppCompatActivity {

    private EditText username, password;
    public Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halamanlogin);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginbutton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("elkomxmalang") && password.getText().toString().equals("matapancing")){
                    Toast.makeText(halamanlogin.this,"Login Succesfull",Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(halamanlogin.this, Kantor.class));
                            finish();
                        }
                    },500);
                }else{
                    Toast.makeText(halamanlogin.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}