/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Hoadon_DTO;
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
public class Hoadon_DAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public Hoadon_DAO() {
    }
    
    public ArrayList<Hoadon_DTO> list()
    {
        ArrayList<Hoadon_DTO> dshd = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM Hoadon";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                String maHD = rs.getString("MaHD");
                String maKH = rs.getString("MaKH");
                String maNV = rs.getString("MaNV");
                String ngayHD = rs.getString("NgayHD");
                int tongtien = rs.getInt("Tongtien");              
                Hoadon_DTO hd = new Hoadon_DTO(maHD,maKH,maNV,ngayHD,tongtien);
                dshd.add(hd);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(Hoadon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dshd;
    }

    public void set(Hoadon_DTO hd) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE Hoadon SET ";
            sql += "MaHD='"+hd.getMaHD()+"', ";
            sql += "MaKH='"+hd.getMaKH()+"', ";
            sql += "MaNV='"+hd.getMaNV()+"', ";
            sql += "NgayHD='"+hd.getNgayHD()+"', ";
            sql += "Tongtien='"+hd.getTongtien()+"' ";
            sql += " WHERE MaHD='"+hd.getMaHD()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }

    public void addhd(Hoadon_DTO hd) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "INSERT INTO Hoadon VALUES (";
                sql += "'"+hd.getMaHD()+"',";
                sql += "'"+hd.getMaKH()+"',";
                sql += "'"+hd.getMaNV()+"',";
                sql += "'"+hd.getNgayHD()+"',";
                sql += "'"+hd.getTongtien()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void deletehd(String mahd) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "DELETE FROM Hoadon WHERE MaHD='"+mahd+"'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }
}
