/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.Sanpham_DAO;
import DTO.Sanpham_DTO;
import java.util.ArrayList;

/**
 *
 * @author Chiquang
 */
public class Sanpham_BUS {
    public ArrayList<Sanpham_DTO> dssp = new ArrayList<>();
    public Sanpham_BUS()
    {   
        
    }
    public ArrayList<Sanpham_DTO> getDSSanpham() {
        try {
            Sanpham_DAO nvDAO = new Sanpham_DAO();
            dssp = nvDAO.list();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return dssp;  
    }
    public Sanpham_DTO getSP(String MaSP)
    {
        for(Sanpham_DTO sp : dssp)
        {
            if(sp.getMaSP().equals(MaSP))
            {
                return sp;
            }
        }
        return null;
    }
    public void listSP()
    {
        Sanpham_DAO spDAO = new Sanpham_DAO();        
        dssp = spDAO.list();
    }
    public void addSP(Sanpham_DTO sp)
    {
        dssp.add(sp);
        Sanpham_DAO spDAO = new Sanpham_DAO();
        spDAO.addSP(sp);
    }

    public void deleteSP(String MaSP)
    {
        for(Sanpham_DTO sp : dssp)
        {
            if(sp.getMaSP().equalsIgnoreCase(MaSP))
            {
                dssp.remove(sp);
                Sanpham_DAO spDAO = new Sanpham_DAO();
                spDAO.deleteSP(MaSP);
                return;
            }
        }
    }
    public void setSP(Sanpham_DTO sp)
    {
        for(int i = 0 ; i < dssp.size() ; i++)
        {
            if(dssp.get(i).getMaSP().equalsIgnoreCase(sp.getMaSP()))
            {
                dssp.set(i, sp);
                Sanpham_DAO spDAO = new Sanpham_DAO();
                spDAO.setSP(sp);
                return;
            }
        }
    }
    public boolean check(String masp)
    {
        for(Sanpham_DTO sp : dssp)
        {
            if(sp.getMaSP().equalsIgnoreCase(masp))
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Sanpham_DTO> getList() {
        return dssp;
    }
}

