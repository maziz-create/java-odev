package DataAccess;

import Exception.SehirBulunamadiException;
import Exception.GecersizApiKeyException;

import Api.OpenWeatherApiManager;
import Core.EntityRepositoryBase;
import Entity.HavaDurumu;

import java.io.IOException;

public class HavaDurumuDal extends EntityRepositoryBase<HavaDurumu> implements IHavaDurumuDal {
    @Override
    public HavaDurumu getWeatherDescription(HavaDurumu havaDurumu, String sehirAdi) throws IOException, SehirBulunamadiException, GecersizApiKeyException {
        OpenWeatherApiManager apiManager = new OpenWeatherApiManager();
        havaDurumu.setDescription(apiManager.getWeatherDescription(sehirAdi));
        return havaDurumu;
    }

    @Override
    public void kimlikGoster(HavaDurumu havaDurumu) {
        System.out.println("Nesnenin kimliği => " + havaDurumu.toString());
    }
}