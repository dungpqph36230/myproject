package com.example.myproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "myProject", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String khachHang = "Create table KhachHang(hoten Text Primary Key, email Text, matkhau Text)";
        sqLiteDatabase.execSQL(khachHang);

        String useKH = "Insert Into KhachHang Values('Phung Quang Dung', 'dung11092004@gmail.com', '1234')";
        sqLiteDatabase.execSQL(useKH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1) {
            sqLiteDatabase.execSQL("Drop Table if exists KhachHang");
            onCreate(sqLiteDatabase);
        }
    }
}
