package com.example.vaccinationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FourthFragment extends Fragment {
    FragmentManager fragmentManager;
    DBHelper db;
    private Button register;
    private Button login;
    private Button editAppointment;
    private Button deleteAppointment;
    private EditText firstName;
    private EditText lastName;
    private EditText AMKA;
    private EditText telephone;
    private EditText email;
    private EditText date;
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {

        View view = inflater.inflate(R.layout.fragment_fourth, container, false);

        register = (Button) view.findViewById(R.id.register);
        login = (Button) view.findViewById(R.id.login);
        editAppointment = (Button) view.findViewById(R.id.editAppointment);
        deleteAppointment = (Button) view.findViewById(R.id.deleteAppointment);
        firstName = view.findViewById(R.id.firstName);
        lastName = view.findViewById(R.id.lastName);
        AMKA = view.findViewById(R.id.AMKA);
        telephone = view.findViewById(R.id.telephone);
        email = view.findViewById(R.id.email);
        date = view.findViewById(R.id.date);

        db = new DBHelper(getActivity());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName1 = firstName.getText().toString();
                String lastName1 = lastName.getText().toString();
                String AMKA1 = AMKA.getText().toString();
                String telephone1 = telephone.getText().toString();
                String email1 = email.getText().toString();
                String date1 = date.getText().toString();
                if(firstName1.equals("") || lastName1.equals("") || AMKA1.equals("") || telephone1.equals("") || email1.equals("") || date1.equals("")){
                    Toast.makeText(getActivity(), getString(R.string.fill_in_creds_toast), Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean AMKACheck = db.checkAMKA(AMKA1);
                    if(AMKACheck == false){
                       Boolean registerStatus = db.insertData(firstName1, lastName1, AMKA1, telephone1, email1, date1);
                       if(registerStatus){
                           Toast.makeText(getActivity(), getString(R.string.appoint_registered_toast), Toast.LENGTH_SHORT).show();
                       }
                       else
                           Toast.makeText(getActivity(), getString(R.string.appoint_not_registered_toast), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getActivity(), getString(R.string.already_registered_toast), Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), loginActivity.class);
                startActivity(intent);
            }
        });

        editAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), editAppointment.class);
                startActivity(intent);
            }
        });

        deleteAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), deleteAppointment.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
