package services;

import domainmodels.MucDa;
import java.util.ArrayList;

public interface IMucDaService {

    ArrayList<MucDa> getList();

    public void insert(MucDa mucDa);

    public void delete(String id);

    public void update(String id, MucDa mucDa);

}
