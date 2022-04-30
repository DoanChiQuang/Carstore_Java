/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.Hoadon_DAO;
import DTO.Hoadon_DTO;
import java.util.ArrayList;

/**
 *
 * @author Chiquang
 */
public class Hoadon_BUS {
    public ArrayList<Hoadon_DTO> dshd = new ArrayList<>();
    public Hoadon_BUS()
    {   
        
    }
    public ArrayList<Hoadon_DTO> getDSHoadon() {
        try {
            Hoadon_DAO hdDAO = new Hoadon_DAO();
            dshd = hdDAO.list();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return dshd;  
    }
    public Hoadon_DTO getHD(String MaHD)
    {
        for(Hoadon_DTO hd : dshd )
        {
            if(hd.getMaHD().equals(MaHD))
            {
                return hd;
            }
        }
        return null;
    }
    public void listHD()
    {
        Hoadon_DAO hdDAO = new Hoadon_DAO();        
        dshd = hdDAO.list();
    }
    public void addHD(Hoadon_DTO hd)
    {
        dshd.add(hd);
        Hoadon_DAO hdDAO = new Hoadon_DAO();
        hdDAO.addhd(hd);
    }

    public void deleteHD(String MaHD)
    {
        for(Hoadon_DTO hd : dshd)
        {
            if(hd.getMaHD().equalsIgnoreCase(MaHD))
            {
                dshd.remove(hd);
                Hoadon_DAO hdDAO = new Hoadon_DAO();
                hdDAO.deletehd(MaHD);
                return;
            }
        }
    }
    public void setHD(Hoadon_DTO hd)
    {
        for(int i = 0 ; i < dshd.size() ; i++)
        {
            if(dshd.get(i).getMaHD().equalsIgnoreCase(hd.getMaHD()))
            {
                dshd.set(i, hd);
                Hoadon_DAO hdDAO = new Hoadon_DAO();
                hdDAO.set(hd);
                return;
            }
        }
    }
    public boolean check(String mahd)
    {
        for(Hoadon_DTO hd : dshd)
        {
            if(hd.getMaHD().equalsIgnoreCase(mahd))
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Hoadon_DTO> getList() {
        return dshd;
    }
}
