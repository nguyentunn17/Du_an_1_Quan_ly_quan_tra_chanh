/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import java.util.ArrayList;
import repositories.reo_hoadonvn;
import viewModel.HoaDonVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import domainmodels.luong;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.reo_hoadonvn;
import utilities.jdbcUtil;
/**
 *
 * @author Phuong
 */
public class reoimpl_hoadonvm implements reo_hoadonvn{

    @Override
    public ArrayList<HoaDonVM> getAll() {
        ArrayList<HoaDonVM> listhdvm =new ArrayList<>();
        try{
            Connection conn=jdbcUtil.getConnection();
            String sql="select X.Ma,A.NgayTao,B.NguoiTao,C.Ten,C.DiaChi,D.ThanhTien,C.Sdt,D.TrangThai "
                    + "from HOADON X join HINHTHUCTHANHTOAN on X.Id=A.IdHD "
                    + "join NHANVIEN B on B.Id=X.IdNV \n"
                    + "join KHACHHANG C on C.Id=X.IdKH \n"
                    + "join HOADONCHITIET D on X.Id=D.IdHoaDon";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
            ResultSet rs=pre.getResultSet();
            while(rs.next()){
                String mahd=rs.getString("MaHD");
                String ngaytao=rs.getString("NgayTao");
                String nguoitao=rs.getString("NguoiTao");
                String tenkh=rs.getString("TenKH");
                String diachi=rs.getString("DiaChi");
                String tongtien=rs.getString("Tongtien");
                String sdtnguoinhan=rs.getString("SDTNguoiNhan");
                int trangthai=rs.getInt("TrangThai");
                HoaDonVM hdvm=new HoaDonVM(mahd, ngaytao, nguoitao, tenkh, diachi, tongtien, sdtnguoinhan, trangthai);
                listhdvm.add(hdvm);
                
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(reoimpl_luong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listhdvm;
    }

    
    
    
}
