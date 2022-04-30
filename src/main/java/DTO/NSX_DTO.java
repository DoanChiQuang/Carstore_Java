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
public class NSX_DTO {
		private String MaNSX, TenNSX;
		
		public NSX_DTO() {
	        
	    }
	    public NSX_DTO(String MaNSX,String TenNSX) {
	    	this.MaNSX= MaNSX;
	    	this.TenNSX=TenNSX;
	    }
		public String getMaNSX() {
			return MaNSX;
		}
		public void setMaNSX(String maNSX) {
			MaNSX = maNSX;
		}
		public String getTenNSX() {
			return TenNSX;
		}
		public void setTenNSX(String tenNSX) {
			TenNSX = tenNSX;
		}	        
}

