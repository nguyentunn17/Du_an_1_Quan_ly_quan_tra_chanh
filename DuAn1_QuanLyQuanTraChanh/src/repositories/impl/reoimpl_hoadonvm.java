/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import viewmodels.HoaDonVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.reo_hoadonvn;
import utilities.jdbcUtil;

/**
 *
 * @author Phuong
 */
public class reoimpl_hoadonvm implements reo_hoadonvn {

    @Override
    public ArrayList<HoaDonVM> getAll() {
        ArrayList<HoaDonVM> listhdvm = new ArrayList<>();

        Connection conn;
        try {
            conn = jdbcUtil.getConnection();
            String sql = "SELECT dbo.HOADON.MaHD,dbo.HINHTHUCTHANHTOAN.NgayTao,dbo.NHANVIEN.Ten,dbo.KHACHHANG.Ten,\n"
                    + "dbo.KHACHHANG.DiaChi,dbo.HOADONCHITIET.ThanhTien,dbo.KHACHHANG.Sdt,dbo.HINHTHUCTHANHTOAN.TrangThai\n"
                    + "FROM   dbo.HINHTHUCTHANHTOAN INNER JOIN\n"
                    + "             dbo.HOADON ON dbo.HINHTHUCTHANHTOAN.IdHD = dbo.HOADON.Id INNER JOIN\n"
                    + "             dbo.HOADONCHITIET ON dbo.HOADON.Id = dbo.HOADONCHITIET.IdHD INNER JOIN\n"
                    + "             dbo.KHACHHANG ON dbo.HOADON.IdKH = dbo.KHACHHANG.Id INNER JOIN\n"
                    + "             dbo.NHANVIEN ON dbo.HINHTHUCTHANHTOAN.IdNV = dbo.NHANVIEN.Id AND dbo.HOADON.IdNV = dbo.NHANVIEN.Id";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
            ResultSet rs = pre.getResultSet();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                String ngaytao = rs.getString("NgayTao");
                String nguoitao = rs.getString("NguoiTao");
                String tenkh = rs.getString("TenKH");
                String diachi = rs.getString("DiaChi");
                String tongtien = rs.getString("Tongtien");
                String sdtnguoinhan = rs.getString("SDTNguoiNhan");
                int trangthai = rs.getInt("TrangThai");
                HoaDonVM hdvm = new HoaDonVM(mahd, ngaytao, nguoitao, tenkh, diachi, tongtien, sdtnguoinhan, trangthai);
                listhdvm.add(hdvm);

            }
        } catch (Exception ex) {
            Logger.getLogger(reoimpl_hoadonvm.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listhdvm;
    }

}
