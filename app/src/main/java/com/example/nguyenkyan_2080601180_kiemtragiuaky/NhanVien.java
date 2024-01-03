package com.example.nguyenkyan_2080601180_kiemtragiuaky;

public class NhanVien {
    private int MaNV;
    private String HoTen;
    private String Email;
    private Khoa khoa;
    private String image;

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public NhanVien(String hoTen, String email, Khoa khoa, String image) {
        HoTen = hoTen;
        Email = email;
        this.khoa = khoa;
        this.image = image;
    }

    public NhanVien(){
    }
}
