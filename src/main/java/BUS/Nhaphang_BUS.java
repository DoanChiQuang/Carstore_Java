/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.Nhaphang_DAO;
import DTO.Nhaphang_DTO;
import java.util.ArrayList;

/**
 *
 * @author Chiquang
 */
public class Nhaphang_BUS {
    public ArrayList<Nhaphang_DTO> dsnh = new ArrayList<>();
    public Nhaphang_BUS()
    {   
        
    }
    public ArrayList<Nhaphang_DTO> getDSNhaphang() {
        try {
            Nhaphang_DAO nhDAO = new Nhaphang_DAO();
            dsnh = nhDAO.list();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return dsnh;  
    }
    public Nhaphang_DTO getNH(String MaNH)
    {
        for(Nhaphang_DTO nh : dsnh )
        {
            if(nh.getMaNH().equals(MaNH))
            {
                return nh;
            }
        }
        return null;
    }
    public void listNH()
    {
        Nhaphang_DAO nhDAO = new Nhaphang_DAO();        
        dsnh = nhDAO.list();
    }
    public void addNH(Nhaphang_DTO sp)
    {
        dsnh.add(sp);
        Nhaphang_DAO nhDAO = new Nhaphang_DAO();
        nhDAO.addnh(sp);
    }

    public void deleteNH(String MaNH)
    {
        for(Nhaphang_DTO nh : dsnh)
        {
            if(nh.getMaNH().equalsIgnoreCase(MaNH))
            {
                dsnh.remove(nh);
                Nhaphang_DAO nhDAO = new Nhaphang_DAO();
                nhDAO.deletenh(MaNH);
                return;
            }
        }
    }
    public void setNH(Nhaphang_DTO s)
    {
        for(int i = 0 ; i < dsnh.size() ; i++)
        {
            if(dsnh.get(i).getMaNH().equalsIgnoreCase(s.getMaNH()))
            {
                dsnh.set(i, s);
                Nhaphang_DAO nhDAO = new Nhaphang_DAO();
                nhDAO.set(s);
                return;
            }
        }
    }
    public boolean check(String manh)
    {
        for(Nhaphang_DTO nh : dsnh)
        {
            if(nh.getMaNH().equalsIgnoreCase(manh))
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Nhaphang_DTO> getList() {
        return dsnh;
    }
}
