/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.Loai_DAO;
import DTO.Loai_DTO;
import java.util.ArrayList;

/**
 *
 * @author Chiquang
 */
public class Loai_BUS {
    public ArrayList<Loai_DTO> dsl = new ArrayList<>();
    public Loai_BUS()
    {   
        
    }
    public ArrayList<Loai_DTO> getDSLoai() {
        try {
            Loai_DAO lDAO = new Loai_DAO();
            dsl = lDAO.list();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return dsl;  
    }
    public Loai_DTO getL(String MaL)
    {
        for(Loai_DTO l : dsl )
        {
            if(l.getMaLoai().equals(MaL))
            {
                return l;
            }
        }
        return null;
    }
    public void listL()
    {
        Loai_DAO lDAO = new Loai_DAO();        
        dsl = lDAO.list();
    }
    public void addL(Loai_DTO sp)
    {
        dsl.add(sp);
        Loai_DAO lDAO = new Loai_DAO();
        lDAO.addl(sp);
    }

    public void deleteL(String MaL)
    {
        for(Loai_DTO l : dsl)
        {
            if(l.getMaLoai().equalsIgnoreCase(MaL))
            {
                dsl.remove(l);
                Loai_DAO lDAO = new Loai_DAO();
                lDAO.deletel(MaL);
                return;
            }
        }
    }
    public void setL(Loai_DTO s)
    {
        for(int i = 0 ; i < dsl.size() ; i++)
        {
            if(dsl.get(i).getMaLoai().equalsIgnoreCase(s.getMaLoai()))
            {
                dsl.set(i, s);
                Loai_DAO lDAO = new Loai_DAO();
                lDAO.set(s);
                return;
            }
        }
    }
    public boolean check(String mal)
    {
        for(Loai_DTO l : dsl)
        {
            if(l.getMaLoai().equalsIgnoreCase(mal))
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Loai_DTO> getList() {
        return dsl;
    }
}
