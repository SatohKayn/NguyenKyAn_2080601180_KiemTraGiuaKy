package com.example.nguyenkyan_2080601180_kiemtragiuaky;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import android.util.Log;

public class KhoaDAO {
    KhoaHelper khoaHelper;

    public KhoaDAO(Context context)
    {
        khoaHelper = new KhoaHelper(context);
    }

    public List<Khoa> GetAll()
    {
        SQLiteDatabase db = khoaHelper.getWritableDatabase();
        List<Khoa> listProduct = new ArrayList<>();
        String query = "SELECT * FROM Khoa";
        Cursor c = db.rawQuery(query, null);
        while (c.moveToNext())
        {
            Khoa temp = new Khoa();
            temp.setMaso(c.getInt(0));
            temp.setTenkhoa(c.getString(1));
            listProduct.add(temp);
        }
        return listProduct;
    }

    public void Insert(Khoa p) {
        String s = p.getTenkhoa();
        SQLiteDatabase db = khoaHelper.getWritableDatabase();
        //c1: sử dụng contentValues
        ContentValues values = new ContentValues();
        values.put("khoa_name", p.getTenkhoa());
        long newRowId =db.insert("Khoa", null, values);

        if (newRowId != -1) {
            // The data was successfully inserted
            Log.d("Insert", "Data inserted successfully with row ID: " + newRowId);
        } else {
            // There was an error inserting the data
            Log.e("Insert", "Error inserting data into the database");
        }
    }

    public void Delete(String khoaId) {
        SQLiteDatabase db = khoaHelper.getWritableDatabase();
        //c1: sử dụng delete
        db.delete("khoa", "khoa_name=?", new String[]{String.valueOf(khoaId)});
    }

}
