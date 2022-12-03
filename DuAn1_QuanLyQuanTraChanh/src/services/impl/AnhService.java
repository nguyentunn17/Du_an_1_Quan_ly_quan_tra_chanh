/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.AnhSanPham;
import java.util.ArrayList;
import repositories.IAnhRepository;
import repositories.impl.AnhRepository;
import services.IAnhService;
import viewmodels.AnhViewModel;

/**
 *
 * @author Hung
 */
public class AnhService implements IAnhService {

    private final IAnhRepository anhRepository;

    public AnhService() {
        this.anhRepository = new AnhRepository();
    }

    @Override
    public ArrayList<AnhViewModel> read() {
        return this.anhRepository.read();
    }

    @Override
    public void create(AnhSanPham asp) {
        this.anhRepository.create(asp);
    }

    @Override
    public void update(AnhSanPham asp, String id) {
        this.anhRepository.update(asp, id);
    }

    @Override
    public void delete(String id) {
        this.anhRepository.delete(id);
    }

}
