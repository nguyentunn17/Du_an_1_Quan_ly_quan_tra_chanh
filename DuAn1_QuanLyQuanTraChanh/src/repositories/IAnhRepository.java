package repositories;

import domainmodels.AnhSanPham;
import java.util.ArrayList;

public interface IAnhRepository {

    ArrayList<AnhSanPham> read();

    void create(AnhSanPham asp);

    void update(AnhSanPham asp, String id);

    void delete(String id);
}
