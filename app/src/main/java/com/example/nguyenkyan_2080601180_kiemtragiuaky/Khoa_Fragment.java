package com.example.nguyenkyan_2080601180_kiemtragiuaky;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class Khoa_Fragment extends Fragment {

    FloatingActionButton floatingActionButton;

    RecyclerView recyclerView;
    Button btnDel;





    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater,container,savedInstanceState);
        View view= inflater.inflate(R.layout.fragment_khoa,container,false);
        floatingActionButton=view.findViewById(R.id.floatingActionButton);
        CustomAlertDialog customeAlertDialog= new CustomAlertDialog(getActivity());
        btnDel = view.findViewById(R.id.button);
        CustomDialog4 customDialog4= new CustomDialog4(getActivity());
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customeAlertDialog.show();
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customDialog4.show();
            }
        });
        recyclerView=view.findViewById(R.id.rcvkhoa);
        //hàm lấy danh sách product
        KhoaDAO productDAO = new KhoaDAO(getActivity());
        List<Khoa> khoaList= productDAO.GetAll();
        //đổ dữ liệu lên productAdapter
        KhoaAdapter productAdapter = new KhoaAdapter(khoaList);
        //gán dữ liệu vào RecyclerView
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    //Ham swipe xoa khoa

    public void addScreen(View view)
    {
        //        Intent intent = new Intent(this, addKhoa.class);
        //        getActivity().startActivity(intent);

    }



}
