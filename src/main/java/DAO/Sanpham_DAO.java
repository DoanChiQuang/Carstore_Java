/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.Sanpham_DTO;
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

public class Sanpham_DAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public Sanpham_DAO() {
    }
    
    public ArrayList<Sanpham_DTO> list()
    {
        ArrayList<Sanpham_DTO> dssp = new ArrayList<>();
        try {
            String sql = "SELECT * FROM QLSanpham";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                String maSP = rs.getString("MASP");
                String tenSP = rs.getString("TENSP");
                String maLoai = rs.getString("MaLoai");
                int SL = rs.getInt("SL");
                int Gia = rs.getInt("GIA");
                String maNSX = rs.getString("MaNSX");              
                Sanpham_DTO sp = new Sanpham_DTO(maSP,tenSP,maLoai,SL,Gia,maNSX);
                dssp.add(sp);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(Sanpham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dssp;
    }

    public void setSP(Sanpham_DTO sp) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE QLSanpham SET ";
            sql += "MASP='"+sp.getMaSP()+"', ";
            sql += "TENSP='"+sp.getTenSP()+"', ";
            sql += "MaLoai='"+sp.getMaLoai()+"', ";
            sql += "SL='"+sp.getSoluong()+"', ";
            sql += "GIA='"+sp.getGia()+"', ";
            sql += "MaNSX='"+sp.getMaNSX()+"' ";
            sql += " WHERE MASP='"+sp.getMaSP()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }

    public void addSP(Sanpham_DTO sp) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "INSERT INTO QLSanpham VALUES (";
                sql += "'"+sp.getMaSP()+"',";
                sql += "'"+sp.getTenSP()+"',";
                sql += "'"+sp.getMaLoai()+"',";
                sql += "'"+sp.getSoluong()+"',";
                sql += "'"+sp.getGia()+"',";
                sql += "'"+sp.getMaNSX()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void deleteSP(String masp) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "DELETE FROM QLSanpham WHERE MASP='"+masp+"'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }
}

