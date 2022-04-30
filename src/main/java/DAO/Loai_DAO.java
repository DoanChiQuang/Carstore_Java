/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Loai_DTO;
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
public class Loai_DAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public Loai_DAO() {
    }
    
    public ArrayList<Loai_DTO> list()
    {
        ArrayList<Loai_DTO> dsl = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM Loai";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                String maL = rs.getString("MaLoai");
                String tenL = rs.getString("TenLoai");             
                Loai_DTO l = new Loai_DTO(maL,tenL);
                dsl.add(l);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(Loai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dsl;
    }

    public void set(Loai_DTO l) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE Loai SET ";
            sql += "MaLoai='"+l.getMaLoai()+"', ";
            sql += "TenLoai='"+l.getTenLoai()+"' ";
            sql += " WHERE MaLoai='"+l.getMaLoai()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }

    public void addl(Loai_DTO l) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "INSERT INTO Loai VALUES (";
                sql += "'"+l.getMaLoai()+"',";
                sql += "'"+l.getTenLoai()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void deletel(String mal) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "DELETE FROM Loai WHERE MaLoai='"+mal+"'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }
}
