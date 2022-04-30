/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NSX_DTO;
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
public class NSX_DAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public NSX_DAO() {
    }
    
    public ArrayList<NSX_DTO> list()
    {
        ArrayList<NSX_DTO> dsnsx = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM NSX";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                String maNSX = rs.getString("MaNSX");
                String tenNSX = rs.getString("TenNSX");
                NSX_DTO nsx = new NSX_DTO(maNSX,tenNSX);
                dsnsx.add(nsx);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(NSX_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dsnsx;
    }

    public void setnsx(NSX_DTO nsx) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE NSX SET ";
            sql += "MaNSX='"+nsx.getMaNSX()+"', ";
            sql += "TenNSX='"+nsx.getTenNSX()+"' ";
            sql += " WHERE MaNSX='"+nsx.getMaNSX()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }

    public void addnsx(NSX_DTO nsx) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "INSERT INTO NSX VALUES (";
                sql += "'"+nsx.getMaNSX()+"',";
                sql += "'"+nsx.getTenNSX()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void deletensx(String mansx) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "DELETE FROM NSX WHERE MaNSX='"+mansx+"'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }
}

