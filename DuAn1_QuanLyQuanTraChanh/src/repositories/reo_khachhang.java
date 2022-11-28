/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import domainmodels.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author Phuong
 */
public interface reo_khachhang {
    ArrayList<KhachHang> getAll();

    boolean insert(KhachHang kh);

    boolean Update(String Ma, KhachHang kh);

    boolean delete(String Ma);
}
