/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Nhaphang_DTO;
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
public class Nhaphang_DAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public Nhaphang_DAO() {
    }
    
    public ArrayList<Nhaphang_DTO> list()
    {
        ArrayList<Nhaphang_DTO> dsnh = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM Nhaphang";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                String maNH = rs.getString("MaNH");
                String maNCC = rs.getString("MaNCC");
                String maSP = rs.getString("MaSP");
                String Ngaynhap = rs.getString("Ngaynhap");
                int dongia = rs.getInt("Dongianhap");
                int sl = rs.getInt("SL");
                int tongtien = rs.getInt("Tongtien");          
                Nhaphang_DTO nh = new Nhaphang_DTO(maNH,maNCC,maSP,Ngaynhap,dongia,sl,tongtien);
                dsnh.add(nh);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(Nhaphang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dsnh;
    }

    public void set(Nhaphang_DTO nh) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE Nhaphang SET ";
            sql += "MaNH='"+nh.getMaNH()+"', ";
            sql += "MaNCC='"+nh.getMaNCC()+"', ";
            sql += "MaSP='"+nh.getMaSP()+"', ";
            sql += "Ngaynhap='"+nh.getNgaynhap()+"', ";
            sql += "Dongianhap='"+nh.getDongia()+"', ";
            sql += "SL='"+nh.getSl()+"', ";
            sql += "Tongtien='"+nh.getTongtien()+"' ";
            sql += " WHERE MaNH='"+nh.getMaNH()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }

    public void addnh(Nhaphang_DTO nh) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "INSERT INTO Nhaphang VALUES (";
                sql += "'"+nh.getMaNH()+"',";
                sql += "'"+nh.getMaNCC()+"',";
                sql += "'"+nh.getMaSP()+"',";
                sql += "'"+nh.getNgaynhap()+"',";
                sql += "'"+nh.getDongia()+"',";
                sql += "'"+nh.getSl()+"',";
                sql += "'"+nh.getTongtien()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void deletenh(String manh) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "DELETE FROM Nhaphang WHERE MaNH='"+manh+"'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }
}
