/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.MucDa;
import java.util.ArrayList;
import repositories.impl.KichThuoc_impl;
import repositories.impl.MucDa_impl;
import repositories.impl.MucDuong_impl;
import services.MucDa_Services;
import services.MucDuong_Services;
import services.IKichThuocService;

/**
 *
 * @author Inspiron
 */
public class MucDa_sv_impl implements MucDa_Services{
    private MucDa_impl mucDa_impl;

    public MucDa_sv_impl() {
        this.mucDa_impl=new MucDa_impl();
    }
    

    @Override
    public ArrayList<MucDa> getList() {
       return this.mucDa_impl.getAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(MucDa mucDa) {
        this.mucDa_impl.insert(mucDa);
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        this.mucDa_impl.delete(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(String id, MucDa mucDa) {
        this.mucDa_impl.update(id, mucDa);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
