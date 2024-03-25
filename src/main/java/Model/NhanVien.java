/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class NhanVien {
    private String MaNhanVien;
    private String TenNhanVien;
    private String Password;
    private String Phone;
    private String Email;
    private String CMND;
    private Date NgayLamViec;
    private String CaLamViec;
    private String LuongCoBan;
    private String HeSoLuong;
    private String TienLuong;

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public String getCMND() {
        return CMND;
    }

    public Date getNgayLamViec() {
        return NgayLamViec;
    }

    public String getCaLamViec() {
        return CaLamViec;
    }

    public String getLuongCoBan() {
        return LuongCoBan;
    }

    public String getHeSoLuong() {
        return HeSoLuong;
    }

    public String getTienLuong() {
        return TienLuong;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public void setNgayLamViec(Date NgayLamViec) {
        this.NgayLamViec = NgayLamViec;
    }

    public void setCaLamViec(String CaLamViec) {
        this.CaLamViec = CaLamViec;
    }

    public void setLuongCoBan(String LuongCoBan) {
        this.LuongCoBan = LuongCoBan;
    }

    public void setHeSoLuong(String HeSoLuong) {
        this.HeSoLuong = HeSoLuong;
    }

    public void setTienLuong(String TienLuong) {
        this.TienLuong = TienLuong;
    }

    public NhanVien(String MaNhanVien, String TenNhanVien, String Password, String Phone, String Email, String CMND, Date NgayLamViec, String CaLamViec, String LuongCoBan, String HeSoLuong, String TienLuong) {
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.Password = Password;
        this.Phone = Phone;
        this.Email = Email;
        this.CMND = CMND;
        this.NgayLamViec = NgayLamViec;
        this.CaLamViec = CaLamViec;
        this.LuongCoBan = LuongCoBan;
        this.HeSoLuong = HeSoLuong;
        this.TienLuong = TienLuong;
    }

    public NhanVien() {
    }

}
