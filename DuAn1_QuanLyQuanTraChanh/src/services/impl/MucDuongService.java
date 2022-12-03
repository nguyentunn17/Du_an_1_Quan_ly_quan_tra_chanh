/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.MucDuong;
import java.util.ArrayList;
import repositories.impl.KichThuoc_impl;
import repositories.impl.MucDuong_impl;
import services.KichThuoc_Services;
import services.MucDuong_Services;

/**
 *
 * @author Inspiron
 */
public class MucDuong_sv_impl implements MucDuong_Services{
    private MucDuong_impl mucDuong_impl;

    public MucDuong_sv_impl() {
        this.mucDuong_impl=new MucDuong_impl();
    }
    

    @Override
    public ArrayList<MucDuong> getList() {
       return this.mucDuong_impl.getAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(MucDuong mucDuong) {
        this.mucDuong_impl.insert(mucDuong);
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        this.mucDuong_impl.delete(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(String id, MucDuong mucDuong) {
        this.mucDuong_impl.update(id, mucDuong);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
