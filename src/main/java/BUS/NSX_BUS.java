/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NSX_DAO;
import DTO.NSX_DTO;
import java.util.ArrayList;

/**
 *
 * @author Chiquang
 */
public class NSX_BUS {
    public ArrayList<NSX_DTO> dsnsx = new ArrayList<>();
    public NSX_BUS()
    {   
        
    }
    public ArrayList<NSX_DTO> getDSNSX() {
        try {
            NSX_DAO nsxDAO = new NSX_DAO();
            dsnsx = nsxDAO.list();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return dsnsx;  
    }
    public NSX_DTO getNSX(String MaNSX)
    {
        for(NSX_DTO nsx : dsnsx )
        {
            if(nsx.getMaNSX().equals(MaNSX))
            {
                return nsx;
            }
        }
        return null;
    }
    public void listNSX()
    {
        NSX_DAO nsxDAO = new NSX_DAO();        
        dsnsx = nsxDAO.list();
    }
    public void addNSX(NSX_DTO nsx)
    {
        dsnsx.add(nsx);
        NSX_DAO nsxDAO = new NSX_DAO();
        nsxDAO.addnsx(nsx);
    }

    public void deleteNSX(String MaNSX)
    {
        for(NSX_DTO nsx : dsnsx)
        {
            if(nsx.getMaNSX().equalsIgnoreCase(MaNSX))
            {
                dsnsx.remove(nsx);
                NSX_DAO nsxDAO = new NSX_DAO();
                nsxDAO.deletensx(MaNSX);
                return;
            }
        }
    }
    public void setNSX(NSX_DTO nsx)
    {
        for(int i = 0 ; i < dsnsx.size() ; i++)
        {
            if(dsnsx.get(i).getMaNSX().equalsIgnoreCase(nsx.getMaNSX()))
            {
                dsnsx.set(i, nsx);
                NSX_DAO nsxDAO = new NSX_DAO();
                nsxDAO.setnsx(nsx);
                return;
            }
        }
    }
    public boolean check(String mansx)
    {
        for(NSX_DTO nsx : dsnsx)
        {
            if(nsx.getMaNSX().equalsIgnoreCase(mansx))
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<NSX_DTO> getList() {
        return dsnsx;
    }
}

