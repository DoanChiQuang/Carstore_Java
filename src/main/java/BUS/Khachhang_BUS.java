/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.Khachhang_DAO;
import DTO.Khachhang_DTO;
import java.util.ArrayList;

/**
 *
 * @author Chiquang
 */
public class Khachhang_BUS {
    public ArrayList<Khachhang_DTO> dskh = new ArrayList<>();
    public Khachhang_BUS()
    {   
        
    }
    public ArrayList<Khachhang_DTO> getDSKhachhang() {
        try {
            Khachhang_DAO khDAO = new Khachhang_DAO();
            dskh = khDAO.list();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return dskh;  
    }
    public Khachhang_DTO getKH(String MaKH)
    {
        for(Khachhang_DTO kh : dskh )
        {
            if(kh.getMaKH().equals(MaKH))
            {
                return kh;
            }
        }
        return null;
    }
    public void listKH()
    {
        Khachhang_DAO khDAO = new Khachhang_DAO();        
        dskh = khDAO.list();
    }
    public void addKH(Khachhang_DTO kh)
    {
        dskh.add(kh);
        Khachhang_DAO khDAO = new Khachhang_DAO();
        khDAO.addkh(kh);
    }

    public void deleteKH(String MaKH)
    {
        for(Khachhang_DTO kh : dskh)
        {
            if(kh.getMaKH().equalsIgnoreCase(MaKH))
            {
                dskh.remove(kh);
                Khachhang_DAO khDAO = new Khachhang_DAO();
                khDAO.deletekh(MaKH);
                return;
            }
        }
    }
    public void setKH(Khachhang_DTO kh)
    {
        for(int i = 0 ; i < dskh.size() ; i++)
        {
            if(dskh.get(i).getMaKH().equalsIgnoreCase(kh.getMaKH()))
            {
                dskh.set(i, kh);
                Khachhang_DAO khDAO = new Khachhang_DAO();
                khDAO.set(kh);
                return;
            }
        }
    }
    public boolean check(String makh)
    {
        for(Khachhang_DTO kh : dskh)
        {
            if(kh.getMaKH().equalsIgnoreCase(makh))
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Khachhang_DTO> getList() {
        return dskh;
    }
}
