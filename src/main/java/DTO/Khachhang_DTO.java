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
public class Khachhang_DTO {
		private String MaKH, HoKH, TenKH, Diachi;
		private int SDT;
		
		public Khachhang_DTO() {
	        
	    }
	    public Khachhang_DTO(String MaKH,String HoKH, String TenKH, String Diachi, int SDT) {
	        this.MaKH= MaKH;
	        this.HoKH= HoKH;
	        this.TenKH= TenKH;
	        this.Diachi= Diachi;
	        this.SDT= SDT;
	    }
		public String getMaKH() {
			return MaKH;
		}
		public void setMaKH(String maKH) {
			MaKH = maKH;
		}
		public String getHoKH() {
			return HoKH;
		}
		public void setHoKH(String hoKH) {
			HoKH = hoKH;
		}
		public String getTenKH() {
			return TenKH;
		}
		public void setTenKH(String tenKH) {
			TenKH = tenKH;
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
	    
}

