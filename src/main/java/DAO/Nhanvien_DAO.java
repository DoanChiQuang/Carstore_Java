/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Nhanvien_DTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Chiquang
 */
public class Nhanvien_DAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public Nhanvien_DAO() {
    }
    
    public ArrayList<Nhanvien_DTO> list()
    {
        ArrayList<Nhanvien_DTO> dsnv = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM QLNhanvien";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                String maNV = rs.getString("MANV");
                String hoNV = rs.getString("HONV");
                String tenNV = rs.getString("TENNV");
                String gioitinh = rs.getString("GIOITINH");
                String namsinh = rs.getString("NAMSINH");
                String quequan = rs.getString("QUEQUAN");
                String diaChi = rs.getString("DIACHI");
                String chucvu = rs.getString("CHUCVU");
                int mucLuong = rs.getInt("MUCLUONG");              
                Nhanvien_DTO nv = new Nhanvien_DTO(maNV,hoNV,tenNV,gioitinh,namsinh,quequan,diaChi,chucvu,mucLuong);
                dsnv.add(nv);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(Nhanvien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dsnv;
    }

    public void set(Nhanvien_DTO nv) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE QLNhanvien SET ";
            sql += "MANV='"+nv.getMaNV()+"', ";
            sql += "HONV='"+nv.getHoNV()+"', ";
            sql += "TENNV='"+nv.getTenNV()+"', ";
            sql += "GIOITINH='"+nv.getGioitinh()+"', ";
            sql += "NAMSINH='"+nv.getNamsinh()+"', ";
            sql += "QUEQUAN='"+nv.getQuequan()+"', ";
            sql += "DIACHI='"+nv.getDiachi()+"', ";
            sql += "CHUCVU='"+nv.getChucvu()+"', ";
            sql += "MUCLUONG='"+nv.getLuong()+"' ";
            sql += " WHERE MANV='"+nv.getMaNV()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }

    public void addnv(Nhanvien_DTO nv) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "INSERT INTO QLNhanvien VALUES (";
                sql += "'"+nv.getMaNV()+"',";
                sql += "'"+nv.getHoNV()+"',";
                sql += "'"+nv.getTenNV()+"',";
                sql += "'"+nv.getGioitinh()+"',";
                sql += "'"+nv.getNamsinh()+"',";
                sql += "'"+nv.getQuequan()+"',";
                sql += "'"+nv.getDiachi()+"',";
                sql += "'"+nv.getChucvu()+"',";
                sql += "'"+nv.getLuong()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void deletenv(String manv) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "DELETE FROM QLNhanvien WHERE MANV='"+manv+"'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }
}
