package com.example.nguyenkyan_2080601180_kiemtragiuaky;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class CustomDialog4 extends Dialog {
    private KhoaDAO khoaDAO;

    EditText editID;
    Button btnsave;

    public CustomDialog4(@NonNull Context context) {
        super(context);
        khoaDAO= new KhoaDAO(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_delete);
        editID = findViewById(R.id.txtInputId);
        btnsave = findViewById(R.id.btnSave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isDataValid()){
                    khoaDAO.Delete(editID.getText().toString().trim());
                    Toast.makeText(getContext(), "Xoá thành công",
                            Toast.LENGTH_SHORT).show();
                    xoaThongTin();
                }
                else {
                    Toast.makeText(getContext(), "Chưa nhập đủ thông tin",
                            Toast.LENGTH_SHORT).show();
                }




            }
        });



    }

    private void xoaThongTin(){
        editID.setText("");
    }
    //hàm lưu thông tin xuống SQLite
        //hàm kiểm tra xem người dùng đã nhập đủ thông tin chưa
        private boolean isDataValid(){
        String ID= editID.getText().toString().trim();
        return !ID.isEmpty();
    }


}
