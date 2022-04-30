/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Chiquang
 */
public class Nhanvien_DTO {
    private String MaNV, HoNV, TenNV, Gioitinh, Namsinh, Quequan, Diachi, Chucvu;
    private int Luong;
    
    public Nhanvien_DTO() {
        
    }
    public Nhanvien_DTO(String MaNV,String HoNV, String TenNV, String Gioitinh, String Namsinh, String Quequan, String Diachi, String Chucvu, int Luong) {
        this.MaNV = MaNV;
        this.HoNV = HoNV;
        this.TenNV = TenNV;
        this.Gioitinh = Gioitinh;
        this.Namsinh = Namsinh;
        this.Quequan = Quequan;
        this.Diachi = Diachi;
        this.Chucvu = Chucvu;
        this.Luong = Luong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoNV() {
        return HoNV;
    }

    public void setHoNV(String HoNV) {
        this.HoNV = HoNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getNamsinh() {
        return Namsinh;
    }

    public void setNamsinh(String Namsinh) {
        this.Namsinh = Namsinh;
    }

    public String getQuequan() {
        return Quequan;
    }

    public void setQuequan(String Quequan) {
        this.Quequan = Quequan;
    }

    public String getChucvu() {
        return Chucvu;
    }

    public void setChucvu(String Chucvu) {
        this.Chucvu = Chucvu;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }
    
}
