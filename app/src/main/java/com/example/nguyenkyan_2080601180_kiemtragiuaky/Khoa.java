package com.example.nguyenkyan_2080601180_kiemtragiuaky;

import java.util.ArrayList;
import java.util.List;

public class Khoa {
    private int maso;
    private String tenkhoa;
    public Khoa(int maso, String tenkhoa) {
        this.maso = maso;
        this.tenkhoa = tenkhoa;
    }
    public Khoa(){
    }

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    public static List<Khoa> getListKhoa(){
        List<Khoa> lsKhoa = new ArrayList<>();
        return lsKhoa;
    }

}
