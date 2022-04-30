/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class Chitiethoadon_DTO {
    private String MaSP;
    private String MaHD;
    private String TenSP;
    private int Gia;
    private int Soluong;

    public Chitiethoadon_DTO(String MaSP, String MaHD, String TenSP, int Gia, int Soluong) {
        this.MaSP = MaSP;
        this.MaHD = MaHD;
        this.TenSP = TenSP;
        this.Gia = Gia;
        this.Soluong = Soluong;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }
    
}
