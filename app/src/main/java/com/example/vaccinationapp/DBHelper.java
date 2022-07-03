package com.example.vaccinationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "Vaccination1",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(firstName Text, lastName Text, AMKA Text primary key, telephone Text, email Text, date Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String firstName, String lastName, String AMKA, String telephone, String email, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("AMKA", AMKA);
        contentValues.put("telephone", telephone);
        contentValues.put("email", email);
        contentValues.put("date", date);
        long result = db.insert("users", null, contentValues);

        //Registration failed
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean updateData(String firstName, String lastName, String AMKA, String telephone, String email, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("AMKA", AMKA);
        contentValues.put("telephone", telephone);
        contentValues.put("email", email);
        contentValues.put("date", date);
        long result = db.update("users", contentValues, "AMKA = ?",new String[] {String.valueOf(AMKA)});

        //Update Table Failed
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean checkAMKA(String AMKA){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where AMKA = ?", new String[] {AMKA});
        if(cursor.getCount()>0){
            return true;
        }
        else
            return false;
    }

    public Boolean deleteRecord(String AMKA, String lastName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Delete from users where AMKA = ? and lastName = ?", new String[]{AMKA, lastName});
        if(cursor.getCount()>0){
            return true;
        }
        else
            return false;
    }

    public Boolean checkAMKALastName(String AMKA, String lastName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where AMKA = ? and lastName = ?", new String[]{AMKA, lastName});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
