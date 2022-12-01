/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.AnhSanPham;
import java.util.ArrayList;

/**
 *
 * @author Hung
 */
public interface IAnhService {
    ArrayList<AnhSanPham> read();

    void create(AnhSanPham asp);

    void update(AnhSanPham asp, String id);

    void delete(String id);
}
