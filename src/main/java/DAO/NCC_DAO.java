/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NCC_DTO;
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
public class NCC_DAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public NCC_DAO() {
    }
    
    public ArrayList<NCC_DTO> list()
    {
        ArrayList<NCC_DTO> dsncc = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM NCC";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                String maNCC = rs.getString("MaNCC");
                String tenNCC = rs.getString("TenNCC");
                String diachi = rs.getString("Diachi");
                int SDT = rs.getInt("SDT");
                int sofax = rs.getInt("SoFax");
                NCC_DTO ncc = new NCC_DTO(maNCC,tenNCC,diachi,SDT,sofax);
                dsncc.add(ncc);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(NCC_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dsncc;
    }

    public void set(NCC_DTO ncc) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE NCC SET ";
            sql += "MaNCC='"+ncc.getMaNCC()+"', ";
            sql += "TenNCC='"+ncc.getTenNCC()+"', ";
            sql += "Diachi='"+ncc.getDiachi()+"', ";
            sql += "SDT='"+ncc.getSDT()+"', ";
            sql += "SoFax='"+ncc.getSoFax()+"' ";
            sql += " WHERE MaNCC='"+ncc.getMaNCC()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }

    public void addncc(NCC_DTO ncc) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "INSERT INTO NCC VALUES (";
                sql += "'"+ncc.getMaNCC()+"',";
                sql += "'"+ncc.getTenNCC()+"',";
                sql += "'"+ncc.getDiachi()+"',";
                sql += "'"+ncc.getSDT()+"',";
                sql += "'"+ncc.getSoFax()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void deletencc(String mancc) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "DELETE FROM NCC WHERE MaNCC='"+mancc+"'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }
}
