package com.example.vaccinationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editAppointment extends AppCompatActivity {

    private EditText firstName, lastName, AMKA, telephone, email, date;
    DBHelper db;
    Button changeAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_appointment);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        AMKA = (EditText) findViewById(R.id.AMKA);
        telephone = (EditText) findViewById(R.id.telephone);
        email = (EditText) findViewById(R.id.email);
        date = (EditText) findViewById(R.id.date);
        changeAppointment = (Button) findViewById(R.id.changeAppointment);
        db = new DBHelper(this);

        changeAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName1 = firstName.getText().toString();
                String lastName1 = lastName.getText().toString();
                String AMKA1 = AMKA.getText().toString();
                String telephone1 = telephone.getText().toString();
                String email1 = email.getText().toString();
                String date1 = date.getText().toString();

                if(firstName1.equals("") || lastName1.equals("") || AMKA1.equals("") || telephone1.equals("") || email1.equals("") || date1.equals("")){
                    Toast.makeText(editAppointment.this, getString(R.string.fill_in_creds_toast), Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean result = db.checkAMKALastName(AMKA1, lastName1);
                    if(result){
                        Boolean result1 = db.updateData(firstName1, lastName1, AMKA1, telephone1, email1, date1);
                        if(result1)
                            Toast.makeText(editAppointment.this, getString(R.string.appoint_updated_toast), Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(editAppointment.this, getString(R.string.update_failed_toast), Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(editAppointment.this, getString(R.string.appoint_not_found_toast), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}