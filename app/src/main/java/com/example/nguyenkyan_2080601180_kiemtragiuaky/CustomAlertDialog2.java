package com.example.nguyenkyan_2080601180_kiemtragiuaky;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class CustomAlertDialog2 extends Dialog {
    private NhanVienDAO khoaDAO;

    EditText editHoTen, editEmail, editIdKhoa, editImage;

    Button btnsave;

    public CustomAlertDialog2(@NonNull Context context) {
        super(context);
        khoaDAO= new NhanVienDAO(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_nhanvien);
        editHoTen = findViewById(R.id.txtInputNameHoTen);
        editEmail = findViewById(R.id.txtInputNameEmail);
        editIdKhoa = findViewById(R.id.txtInputNameKhoa);
        editImage = findViewById(R.id.txtInputNameImage);
        btnsave = findViewById(R.id.btnSave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isDataValid()){
                    saveData();
                    Toast.makeText(getContext(), "Lưu thành công",
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
        editHoTen.setText("");
        editEmail.setText("");
        editIdKhoa.setText("");
        editImage.setText("");
    }
    //hàm lưu thông tin xuống SQLite
    private void saveData(){
        String Name= editHoTen.getText().toString().trim();
        String Email= editEmail.getText().toString().trim();
        String IdKhoa= editIdKhoa.getText().toString().trim();
        String Image= editImage.getText().toString().trim();
        NhanVien khoa = new NhanVien(Name, Email, new Khoa(), Image);
        khoaDAO.Insert(khoa);
    }
    //hàm kiểm tra xem người dùng đã nhập đủ thông tin chưa
    private boolean isDataValid(){
        String Name= editHoTen.getText().toString().trim();
        String Email= editEmail.getText().toString().trim();
        String IdKhoa= editIdKhoa.getText().toString().trim();
        String Image= editImage.getText().toString().trim();
        return !Email.isEmpty() && !Name.isEmpty() && !IdKhoa.isEmpty() && !Image.isEmpty();
    }

}
