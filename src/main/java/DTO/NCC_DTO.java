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
public class NCC_DTO {
    private String MaNCC,TenNCC,Diachi;
    private int SDT,SoFax;
		
    public NCC_DTO() {
	        
    }
    public NCC_DTO(String MaNCC, String TenNCC, String Diachi, int SDT, int SoFax) {
        this.MaNCC=MaNCC;	        
        this.TenNCC= TenNCC;	        
        this.Diachi= Diachi;	        
        this.SDT=SDT;	        
        this.SoFax=SoFax;
    }
    public String getMaNCC() {
        return MaNCC;
    }
    public void setMaNCC(String maNCC) {
        MaNCC = maNCC;
    }
    public String getTenNCC() {
        return TenNCC;
    }
    public void setTenNCC(String tenNCC) {
        TenNCC = tenNCC;
    }
    public String getDiachi() {
        return Diachi;
    }
    public void setDiachi(String diachi) {
        Diachi = diachi;
    }
    public int getSDT() {
        return SDT;
    }
    public void setSDT(int sDT) {
        SDT = sDT;
    }
    public int getSoFax() {
        return SoFax;
    }
    public void setSoFax(int soFax) {
        SoFax = soFax;
    }	    
}


