/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import domainmodels.Ban;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.IBanRepository;
import repositories.impl.reoimpl_luong;
import utilities.jdbcUtil;

/**
 *
 * @author ASUS
 */
public class BanRepository implements IBanRepository {

    @Override
    public ArrayList<Ban> getAll() {
        ArrayList<Ban> listBan = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String sql = "select * from Ban";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
            ResultSet rs = pre.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String maca = rs.getString("MaBan");
                String tenca = rs.getString("TenBan");
                int soNguoi = rs.getInt("SoNguoi");
                int trangThai = rs.getInt("TrangThai");
                Ban b = new Ban(id, maca, tenca, soNguoi, trangThai);
                listBan.add(b);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(reoimpl_luong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBan;
    }

    @Override
    public boolean insert(Ban b) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String insert = "insert into Ban" + "(MaBan,TenBan,SoNguoi,TrangThai)" + "Values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, b.getMaBan());
            ps.setString(2, b.getTenBan());
            ps.setInt(3,b.getSoNguoi());
            ps.setInt(4,b.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean Update(String id, Ban b) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String Update = "update Ban set MaBan=?,TenBan=?,SoNguoi=?,TrangThai=? Where id=?";
            PreparedStatement ps = conn.prepareStatement(Update);
            ps.setString(5, id);
            ps.setString(1, b.getMaBan());
            ps.setString(2, b.getTenBan());
            ps.setInt(3, b.getSoNguoi());
            ps.setInt(4, b.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String delete = "delete from Ban where id = ?";
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
