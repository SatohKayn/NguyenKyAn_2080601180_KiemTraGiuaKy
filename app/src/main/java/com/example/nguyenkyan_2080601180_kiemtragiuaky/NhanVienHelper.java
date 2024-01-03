package com.example.nguyenkyan_2080601180_kiemtragiuaky;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NhanVienHelper extends SQLiteOpenHelper {
    public NhanVienHelper(@Nullable Context context)
    {
        super(context, "QLNhanVien", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = String.format("CREATE TABLE %s (" +
                "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s TEXT, " +
                "%s TEXT, " +
                "%s INTEGER, " +  // Corrected typo here
                "%s TEXT)", "NhanVien", "id", "hoten", "email", "khoa_id", "image");

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion != newVersion) {
            //drop
            String query = "DROP TABLE NhanVien";
            db.execSQL(query);
            //create again
            onCreate(db);
        }
    }
}
