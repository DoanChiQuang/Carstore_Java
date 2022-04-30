/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Chitiethoadon_DTO;
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
public class Chitiethoadon_DAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public Chitiethoadon_DAO() {
    }
    
    public ArrayList<Chitiethoadon_DTO> list()
    {
        ArrayList<Chitiethoadon_DTO> dscthd = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM CTHoadon";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                String maSP = rs.getString("MaSP");
                String maHD = rs.getString("MaHD");
                String tenSP = rs.getString("TenSP");
                int gia = rs.getInt("Gia");
                int soluong = rs.getInt("SL");            
                Chitiethoadon_DTO cthd = new Chitiethoadon_DTO(maSP,maHD,tenSP,gia,soluong);
                dscthd.add(cthd);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(Chitiethoadon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dscthd;
    }

    public void set(Chitiethoadon_DTO cthd) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE CTHoadon SET ";
            sql += "MaSP='"+cthd.getMaSP()+"', ";
            sql += "MaHD='"+cthd.getMaHD()+"', ";
            sql += "TenSP='"+cthd.getTenSP()+"', ";
            sql += "Gia='"+cthd.getGia()+"', ";
            sql += "SL='"+cthd.getSoluong()+"' ";
            sql += " WHERE MaSP='"+cthd.getMaSP()+"' AND MaHD='"+cthd.getMaHD()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }

    public void addcthd(Chitiethoadon_DTO cthd) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "INSERT INTO CTHoadon VALUES (";
                sql += "'"+cthd.getMaSP()+"',";
                sql += "'"+cthd.getMaHD()+"',";
                sql += "'"+cthd.getTenSP()+"',";
                sql += "'"+cthd.getGia()+"',";
                sql += "'"+cthd.getSoluong()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void deletecthd(String masp, String mahd) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "DELETE FROM CTHoadon WHERE MaSP='"+masp+"' AND MaHD='"+mahd+"'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }
}
