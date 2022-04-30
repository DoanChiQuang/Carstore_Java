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
public class Sanpham_DTO {
    private String MaSP, TenSP, DVT, MaLoai, MaNSX, img;
    private int Soluong, Gia;
    public Sanpham_DTO () {
        
    }
    public Sanpham_DTO(String MaSP, String TenSP, String MaLoai, int Soluong, int Gia,String MaNSX) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaLoai = MaLoai;
        this.MaNSX = MaNSX;
        this.Soluong = Soluong;
        this.Gia = Gia;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

//    public String getDVT() {
//        return DVT;
//    }
//
//    public void setDVT(String DVT) {
//        this.DVT = DVT;
//    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getMaNSX() {
        return MaNSX;
    }

    public void setMaNSX(String MaNSX) {
        this.MaNSX = MaNSX;
    }
    
    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }
    
}
