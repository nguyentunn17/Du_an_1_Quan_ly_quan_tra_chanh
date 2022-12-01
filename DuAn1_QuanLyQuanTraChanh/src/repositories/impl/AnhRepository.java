/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import domainmodels.AnhSanPham;
import domainmodels.SanPham;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.IAnhRepository;

/**
 *
 * @author Hung
 */
public class AnhRepository implements IAnhRepository {

    @Override
    public ArrayList<AnhSanPham> read() {
        ArrayList<AnhSanPham> listsp = new ArrayList<>();
        try {
            Connection conn = utilities.jdbcUtil.getConnection();
            String query = "SELECT * FROM HINHANH";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String idSP = rs.getString("idSanpham");
                String ten = rs.getString("tenha");
                String duongDan = rs.getString("duongDan");
                Integer trangThai = rs.getInt("trangThai");
                AnhSanPham asp = new AnhSanPham(id, idSP, ten, duongDan, trangThai);
                listsp.add(asp);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

    @Override
    public void create(AnhSanPham asp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(AnhSanPham asp, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
