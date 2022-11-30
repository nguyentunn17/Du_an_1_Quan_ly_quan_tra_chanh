/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author Phuong
 */
public interface KhachSV {
    ArrayList<KhachHang> getlist();
    String insert(KhachHang kh);
    String Update(String Ma ,KhachHang kh);
    String delete(String Ma);
}
