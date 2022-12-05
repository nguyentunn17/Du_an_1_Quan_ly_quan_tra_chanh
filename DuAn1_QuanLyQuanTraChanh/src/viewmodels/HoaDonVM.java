/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

import java.util.Date;

/**
 *
 * @author Phuong
 */
public class HoaDonVM {
    private String mahd;
    private String ngayTao;
    private Date nguoitao;

    private String tongtien;
    private int trangthai;

    public HoaDonVM() {
    }

    public HoaDonVM(String mahd, String ngayTao, Date nguoitao, String tongtien, int trangthai) {
        this.mahd = mahd;
        this.ngayTao = ngayTao;
        this.nguoitao = nguoitao;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNguoitao() {
        return nguoitao;
    }

    public void setNguoitao(Date nguoitao) {
        this.nguoitao = nguoitao;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

   
    
    
    
}
