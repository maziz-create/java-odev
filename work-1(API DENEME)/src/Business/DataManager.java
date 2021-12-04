package Business;

import DataAccess.IHavaDurumuDal;
import Entity.HavaDurumu;

import java.io.IOException;

public class DataManager implements IDataService {
    IHavaDurumuDal _havaDurumuDal;

    //constructor
    public DataManager(IHavaDurumuDal havaDurumuDal) {
        _havaDurumuDal = havaDurumuDal;
    }

    //implemented functions
    @Override
    public HavaDurumu getWeatherDescription(HavaDurumu havaDurumu, String sehirAdi) throws IOException {
        return _havaDurumuDal.getWeatherDescription(havaDurumu, sehirAdi);
    }
}
