package com.example.nguyenkyan_2080601180_kiemtragiuaky;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NhanVien_Fragment extends Fragment {
    FloatingActionButton floatingActionButton;

    RecyclerView recyclerView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater,container,savedInstanceState);
        View view= inflater.inflate(R.layout.fragment_nhanvien,container,false);
        floatingActionButton=view.findViewById(R.id.floatingActionButton);
        CustomAlertDialog2 customeAlertDialog= new CustomAlertDialog2(getActivity());

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customeAlertDialog.show();
            }
        });
        recyclerView=view.findViewById(R.id.rcvkhoa);
        //hàm lấy danh sách product
        NhanVienDAO productDAO = new NhanVienDAO(getActivity());
        List<NhanVien> khoaList= productDAO.GetAll();
        //đổ dữ liệu lên productAdapter
        NhanVienAdapter productAdapter = new NhanVienAdapter(khoaList);
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
