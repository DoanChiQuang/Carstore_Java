/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Khachhang_DTO;
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
public class Khachhang_DAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public Khachhang_DAO() {
    }
    
    public ArrayList<Khachhang_DTO> list()
    {
        ArrayList<Khachhang_DTO> dskh = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM QLKhachhang";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                String maKH = rs.getString("MAKH");
                String hoKH = rs.getString("HOKH");
                String tenKH = rs.getString("TENKH");
                String diachi = rs.getString("DIACHI");
                int STD = rs.getInt("SDT");            
                Khachhang_DTO kh = new Khachhang_DTO(maKH,hoKH,tenKH,diachi,STD);
                dskh.add(kh);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(Khachhang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dskh;
    }

    public void set(Khachhang_DTO kh) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE QLKhachhang SET ";
            sql += "MAKH='"+kh.getMaKH()+"', ";
            sql += "HOKH='"+kh.getHoKH()+"', ";
            sql += "TENKH='"+kh.getTenKH()+"', ";
            sql += "DIACHI='"+kh.getDiachi()+"', ";
            sql += "SDT='"+kh.getSDT()+"' ";
            sql += " WHERE MAKH='"+kh.getMaKH()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }

    public void addkh(Khachhang_DTO kh) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "INSERT INTO QLKhachhang VALUES (";
                sql += "'"+kh.getMaKH()+"',";
                sql += "'"+kh.getHoKH()+"',";
                sql += "'"+kh.getTenKH()+"',";
                sql += "'"+kh.getDiachi()+"',";
                sql += "'"+kh.getSDT()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void deletekh(String makh) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "DELETE FROM QLKhachhang WHERE MAKH='"+makh+"'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }
}
