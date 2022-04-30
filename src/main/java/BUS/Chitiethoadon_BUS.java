/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.Chitiethoadon_DAO;
import DTO.Chitiethoadon_DTO;
import java.util.ArrayList;

/**
 *
 * @author Chiquang
 */
public class Chitiethoadon_BUS {
    public ArrayList<Chitiethoadon_DTO> dscthd = new ArrayList<>();
    public Chitiethoadon_BUS()
    {   
        
    }
    public ArrayList<Chitiethoadon_DTO> getDSChitiethoadon() {
        try {
            Chitiethoadon_DAO cthdDAO = new Chitiethoadon_DAO();
            dscthd = cthdDAO.list();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return dscthd;  
    }
    public Chitiethoadon_DTO getCTHD(String masp, String mahd)
    {
        for(Chitiethoadon_DTO cthd : dscthd )
        {
            if((cthd.getMaSP().equals(masp))&&(cthd.getMaHD().equals(mahd)))
            {
                return cthd;
            }
        }
        return null;
    }
    public void listCTHD()
    {
        Chitiethoadon_DAO cthdDAO = new Chitiethoadon_DAO();        
        dscthd = cthdDAO.list();
    }
    public void addCTHD(Chitiethoadon_DTO sp)
    {
        dscthd.add(sp);
        Chitiethoadon_DAO cthdDAO = new Chitiethoadon_DAO();
        cthdDAO.addcthd(sp);
    }

    public void deleteCTHD(String masp, String mahd)
    {
        for(Chitiethoadon_DTO cthd : dscthd)
        {
            if((cthd.getMaSP().equalsIgnoreCase(masp))&&(cthd.getMaHD().equalsIgnoreCase(mahd)))
            {
                dscthd.remove(cthd);
                Chitiethoadon_DAO cthdDAO = new Chitiethoadon_DAO();
                cthdDAO.deletecthd(masp,mahd);
                return;
            }
        }
    }
    public void setCTHD(Chitiethoadon_DTO s)
    {
        for(int i = 0 ; i < dscthd.size() ; i++)
        {
            if((dscthd.get(i).getMaSP().equalsIgnoreCase(s.getMaSP()))&&(dscthd.get(i).getMaHD().equalsIgnoreCase(s.getMaHD())))
            {
                dscthd.set(i, s);
                Chitiethoadon_DAO cthdDAO = new Chitiethoadon_DAO();
                cthdDAO.set(s);
                return;
            }
        }
    }
    public boolean check(String masp, String mahd)
    {
        for(Chitiethoadon_DTO cthd : dscthd)
        {
            if((cthd.getMaSP().equalsIgnoreCase(masp))&&(cthd.getMaHD().equalsIgnoreCase(mahd)))
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Chitiethoadon_DTO> getList() {
        return dscthd;
    }
}
