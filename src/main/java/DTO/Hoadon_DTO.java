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
public class Hoadon_DTO {
    private String MaHD;
    private String MaKH;
    private String MaNV;
    private String NgayHD;
    private int Tongtien;

    public Hoadon_DTO(String MaHD, String MaKH, String MaNV, String NgayHD, int Tongtien) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.NgayHD = NgayHD;
        this.Tongtien = Tongtien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getNgayHD() {
        return NgayHD;
    }

    public void setNgayHD(String NgayHD) {
        this.NgayHD = NgayHD;
    }

    public int getTongtien() {
        return Tongtien;
    }

    public void setTongtien(int Tongtien) {
        this.Tongtien = Tongtien;
    }

    
}
