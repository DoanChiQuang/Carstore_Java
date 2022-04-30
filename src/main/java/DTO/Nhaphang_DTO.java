/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author thaip
 */
public class Nhaphang_DTO {

    private String MaNH;
    private String MaNCC;
    private String MaSP;
    private String ngaynhap;
    private int dongia;
    private int sl;
    private int tongtien;

    public Nhaphang_DTO(String MaNH, String MaNCC, String MaSP, String ngaynhap, int dongia, int sl, int tongtien) {
        this.MaNH = MaNH;
        this.MaNCC = MaNCC;
        this.MaSP = MaSP;
        this.ngaynhap = ngaynhap;
        this.dongia = dongia;
        this.sl = sl;
        this.tongtien = tongtien;
    }

    public String getMaNH() {
        return MaNH;
    }

    public void setMaNH(String MaNH) {
        this.MaNH = MaNH;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    
    

}
