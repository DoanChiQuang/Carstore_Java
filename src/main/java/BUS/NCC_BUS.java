/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NCC_DAO;
import DTO.NCC_DTO;
import java.util.ArrayList;

/**
 *
 * @author Chiquang
 */
public class NCC_BUS {
    public ArrayList<NCC_DTO> dsncc = new ArrayList<>();
    public NCC_BUS()
    {   
        
    }
    public ArrayList<NCC_DTO> getDSNCC() {
        try {
            NCC_DAO nvDAO = new NCC_DAO();
            dsncc = nvDAO.list();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return dsncc;  
    }
    public NCC_DTO getNV(String MaNCC)
    {
        for(NCC_DTO ncc : dsncc)
        {
            if(ncc.getMaNCC().equals(MaNCC))
            {
                return ncc;
            }
        }
        return null;
    }
    public void listNV()
    {
        NCC_DAO nccDAO = new NCC_DAO();        
        dsncc = nccDAO.list();
    }
    public void addSP(NCC_DTO ncc)
    {
        dsncc.add(ncc);
        NCC_DAO nccDAO = new NCC_DAO();
        nccDAO.addncc(ncc);
    }

    public void deleteNV(String MaNCC)
    {
        for(NCC_DTO ncc : dsncc)
        {
            if(ncc.getMaNCC().equalsIgnoreCase(MaNCC))
            {
                dsncc.remove(ncc);
                NCC_DAO nccDAO = new NCC_DAO();
                nccDAO.deletencc(MaNCC);
                return;
            }
        }
    }
    public void setNV(NCC_DTO ncc)
    {
        for(int i = 0 ; i < dsncc.size() ; i++)
        {
            if(dsncc.get(i).getMaNCC().equalsIgnoreCase(ncc.getMaNCC()))
            {
                dsncc.set(i, ncc);
                NCC_DAO nccDAO = new NCC_DAO();
                nccDAO.set(ncc);
                return;
            }
        }
    }
    public boolean check(String mancc)
    {
        for(NCC_DTO ncc : dsncc)
        {
            if(ncc.getMaNCC().equalsIgnoreCase(mancc))
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<NCC_DTO> getList() {
        return dsncc;
    }
}

