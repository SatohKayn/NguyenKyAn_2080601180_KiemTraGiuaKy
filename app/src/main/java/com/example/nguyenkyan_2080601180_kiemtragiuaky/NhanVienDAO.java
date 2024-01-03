package com.example.nguyenkyan_2080601180_kiemtragiuaky;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    NhanVienHelper nhanVienHelper;

    public NhanVienDAO(Context context)
    {
        nhanVienHelper = new NhanVienHelper(context);
    }

    public List<NhanVien> GetAll()
    {
        SQLiteDatabase db = nhanVienHelper.getWritableDatabase();
        List<NhanVien> listProduct = new ArrayList<>();
        String query = "SELECT * FROM NhanVien";
        Cursor c = db.rawQuery(query, null);
        while (c.moveToNext())
        {
            NhanVien temp = new NhanVien();
            temp.setMaNV(c.getInt(0));
            temp.setHoTen(c.getString(1));
            temp.setEmail(c.getString(2));
            listProduct.add(temp);
        }
        return listProduct;
    }

    public void Insert(NhanVien p) {
        String s = p.getHoTen();
        SQLiteDatabase db = nhanVienHelper.getWritableDatabase();
        //c1: sử dụng contentValues
        ContentValues values = new ContentValues();
        values.put("hoten", p.getHoTen());
        values.put("email", p.getEmail());
        values.put("khoa_id", 1);
        values.put("image", p.getImage());
        long newRowId =db.insert("NhanVien", null, values);

        if (newRowId != -1) {
            // The data was successfully inserted
            Log.d("Insert", "Data inserted successfully with row ID: " + newRowId);
        } else {
            // There was an error inserting the data
            Log.e("Insert", "Error inserting data into the database");
        }
    }

    public void Delete(String name) {
        SQLiteDatabase db = nhanVienHelper.getWritableDatabase();
        //c1: sử dụng delete
        db.delete("NhanVien", "hoten=?", new String[]{String.valueOf(name)});
    }
}
