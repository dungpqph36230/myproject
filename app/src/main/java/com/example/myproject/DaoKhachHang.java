package com.example.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myproject.database.DbHelper;

public class DaoKhachHang {

    private DbHelper dbHelper;

    public DaoKhachHang(Context context){
        dbHelper = new DbHelper(context);
    }

    public boolean CheckLogin(String email, String pass){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * From KhachHang Where email = ? AND matkhau = ?", new String[]{email, pass});
        return cursor.getCount() > 0;
    }

    public boolean Register(String username,String email, String password){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("hoten", username);
        contentValues.put("email", email);
        contentValues.put("matkhau", password);

        long check = sqLiteDatabase.insert("KhachHang", null, contentValues);
        return check != -1;
    }
}
