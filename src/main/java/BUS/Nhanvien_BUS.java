/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.Nhanvien_DAO;
import DTO.Nhanvien_DTO;
import java.util.ArrayList;

/**
 *
 * @author Chiquang
 */
public class Nhanvien_BUS {
    public ArrayList<Nhanvien_DTO> dsnv = new ArrayList<>();
    public Nhanvien_BUS()
    {   
        
    }
    public ArrayList<Nhanvien_DTO> getDSNhanvien() {
        try {
            Nhanvien_DAO nvDAO = new Nhanvien_DAO();
            dsnv = nvDAO.list();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return dsnv;  
    }
    public Nhanvien_DTO getNV(String MaNV)
    {
        for(Nhanvien_DTO nv : dsnv )
        {
            if(nv.getMaNV().equals(MaNV))
            {
                return nv;
            }
        }
        return null;
    }
    public void listNV()
    {
        Nhanvien_DAO nvDAO = new Nhanvien_DAO();        
        dsnv = nvDAO.list();
    }
    public void addNV(Nhanvien_DTO sp)
    {
        dsnv.add(sp);
        Nhanvien_DAO nvDAO = new Nhanvien_DAO();
        nvDAO.addnv(sp);
    }

    public void deleteNV(String MaNV)
    {
        for(Nhanvien_DTO nv : dsnv)
        {
            if(nv.getMaNV().equalsIgnoreCase(MaNV))
            {
                dsnv.remove(nv);
                Nhanvien_DAO nvDAO = new Nhanvien_DAO();
                nvDAO.deletenv(MaNV);
                return;
            }
        }
    }
    public void setNV(Nhanvien_DTO s)
    {
        for(int i = 0 ; i < dsnv.size() ; i++)
        {
            if(dsnv.get(i).getMaNV().equalsIgnoreCase(s.getMaNV()))
            {
                dsnv.set(i, s);
                Nhanvien_DAO nvDAO = new Nhanvien_DAO();
                nvDAO.set(s);
                return;
            }
        }
    }
    public boolean check(String manv)
    {
        for(Nhanvien_DTO nv : dsnv)
        {
            if(nv.getMaNV().equalsIgnoreCase(manv))
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Nhanvien_DTO> getList() {
        return dsnv;
    }
}
