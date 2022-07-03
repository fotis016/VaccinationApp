package com.example.vaccinationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deleteAppointment extends AppCompatActivity {

    EditText lastNameDelete;
    EditText AMKADelete;
    Button deleteButton;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_appointment);

        lastNameDelete = (EditText) findViewById(R.id.lastNameDelete);
        AMKADelete = (EditText) findViewById(R.id.AMKADelete);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        db = new DBHelper(this);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastName = lastNameDelete.getText().toString();
                String AMKA = AMKADelete.getText().toString();
                if(lastName.equals("") || AMKA.equals("")){
                    Toast.makeText(deleteAppointment.this, getString(R.string.fill_in_creds_toast), Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean result = db.checkAMKALastName(AMKA, lastName);
                    if(result){
                        db.deleteRecord(AMKA, lastName);
                        Toast.makeText(deleteAppointment.this, getString(R.string.succ_cancel_appoint_toast),  Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(deleteAppointment.this, getString(R.string.wrong_creds_toast), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}