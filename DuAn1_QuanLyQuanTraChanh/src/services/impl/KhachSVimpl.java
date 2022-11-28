/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.KhachHang;
import java.util.ArrayList;
import repositories.impl.reoimpl_khachhang;
import repositories.reo_khachhang;
import services.KhachSV;

/**
 *
 * @author Phuong
 */
public class KhachSVimpl implements KhachSV{
    public  reo_khachhang rkhach = new reoimpl_khachhang();

    @Override
    public ArrayList<KhachHang> getlist() {
        return rkhach.getAll();
    }

    @Override
    public String insert(KhachHang kh) {
    if(rkhach.insert(kh)){
            return "Thêm Thành Công";
        }
        return "Thêm Thất bại";
    }

    @Override
    public String Update(String Ma, KhachHang kh) {
        if(rkhach.Update(Ma, kh)){
            return "Sửa Thành Công";
        }
        return "Sửa Thất bại";
    }

    @Override
    public String delete(String Ma) {
        if(rkhach.delete(Ma)){
            return "xóa Thành Công";
        }
        return "xóa Thất bại";
    }
    
}
