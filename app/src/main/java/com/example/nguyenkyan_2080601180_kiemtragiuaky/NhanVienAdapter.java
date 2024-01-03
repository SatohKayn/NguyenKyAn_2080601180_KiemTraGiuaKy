package com.example.nguyenkyan_2080601180_kiemtragiuaky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.ViewHolder>  {
    private List<NhanVien> lstNhanVien;

    public NhanVienAdapter(List<NhanVien> lstNhanVien)
    {
        this.lstNhanVien =lstNhanVien;
    }
    public NhanVienAdapter(){

    }

    @NonNull
    @Override
    public NhanVienAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View khoaView = inflater.inflate(R.layout.item_nhanvien,parent,false);
        NhanVienAdapter.ViewHolder viewHolder = new NhanVienAdapter.ViewHolder(khoaView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NhanVienAdapter.ViewHolder holder, int position) {
        NhanVien temp = lstNhanVien.get(position);
        holder.tv.setText(temp.getHoTen() + " - Email: " + temp.getEmail() );
    }

    @Override
    public int getItemCount() {

        return lstNhanVien.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tv=(TextView)itemView.findViewById(R.id.tvnhanvien);
        }

    }



}
