/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.ArrayList;
import repositories.impl.reoimpl_hoadonvm;
import repositories.reo_hoadonvn;
import services.HoaDonSV;
import viewmodels.HoaDonVM;

/**
 *
 * @author Phuong
 */
public class HoaDonSVimpl implements HoaDonSV{
private reo_hoadonvn rhdvm=new reoimpl_hoadonvm();
    @Override
    public ArrayList<HoaDonVM> getlist() {
        return rhdvm.getAll();
    }
    
}
