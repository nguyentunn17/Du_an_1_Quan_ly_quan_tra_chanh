/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import domainmodels.KhachHang;
import java.util.ArrayList;
import repositories.reo_khachhang;
import utilities.jdbcUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Phuong
 */
public class reoimpl_khachhang implements reo_khachhang{
   
    @Override
    public ArrayList<KhachHang> getAll() {
        ArrayList<KhachHang> listkhach =new ArrayList<>();
        try{
            Connection conn=jdbcUtil.getConnection();
            String sql="select * from KHACHHANG";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.executeQuery();
            ResultSet rs=pre.getResultSet();
            while(rs.next()){
                String makh=rs.getString("Ma");
                String tenkh=rs.getString("Ten");
                String ngaysinh=rs.getString("NgaySinh");
                String sdt=rs.getString("Sdt");
                String diachi=rs.getString("DiaChi");
                String gioitinh=rs.getString("GioiTinh");
                String GhiChu=rs.getString("GhiChu");
                KhachHang kh=new KhachHang(makh, tenkh, sdt, ngaysinh, diachi, gioitinh, GhiChu);
                listkhach.add(kh);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(reoimpl_khachhang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listkhach;
    }

    @Override
    public boolean insert(KhachHang kh) {
        try {
            Connection conn=jdbcUtil.getConnection();
            String insert = "insert into KhachHang" + "(Ma,Ten,NgaySinh,Sdt,DiaChi,GioiTinh,GhiChu)" + "Values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, kh.getMakh());
            ps.setString(2, kh.getTenkh());
           ps.setString(3, kh.getNgaysinh());
           ps.setString(6, kh.getGioitinh());
           ps.setString(4, kh.getSdt());
           ps.setString(5, kh.getDiachi());
           ps.setString(7, kh.getGhichu());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean Update(String Ma, KhachHang kh) {try {
            Connection conn=jdbcUtil.getConnection();
            String Update = "update KHACHHANG set Ten=?,NgaySinh=?,Sdt=?,DiaChi=?,GioiTinh=?,Ghichu=? Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(Update);
            ps.setString(7, Ma);
            ps.setString(1, kh.getTenkh());
            ps.setString(2, kh.getNgaysinh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getDiachi());
            ps.setString(5, kh.getGioitinh());
            ps.setString(6, kh.getGhichu());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(String Ma) {
         try {
            Connection conn=jdbcUtil.getConnection();
            String delete = "delete from KHACHHANG where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setString(1, Ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
}
