package com.example.vaccinationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText lastNameCheck;
    EditText AMKACheck;
    Button checkLogin;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lastNameCheck = (EditText) findViewById(R.id.lastNameCheck);
        AMKACheck = (EditText) findViewById(R.id.AMKACheck);
        checkLogin = (Button) findViewById(R.id.checkLogin);
        db = new DBHelper(this);

        checkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastName = lastNameCheck.getText().toString();
                String AMKA = AMKACheck.getText().toString();
                if(lastName.equals("") || AMKA.equals("")){
                    Toast.makeText(loginActivity.this, getString(R.string.fill_in_creds_toast), Toast.LENGTH_SHORT).show();
                }
                else{
                  Boolean result = db.checkAMKALastName(AMKA, lastName);
                  if(result){
                      Toast.makeText(loginActivity.this, getString(R.string.succ_appoint_toast) + AMKA + " " + lastName, Toast.LENGTH_LONG).show();
                  }
                  else{
                      Toast.makeText(loginActivity.this, getString(R.string.wrong_creds_toast), Toast.LENGTH_SHORT).show();
                  }
                }
            }
        });
    }
}