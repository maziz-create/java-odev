package DataAccess;

import Exception.SehirBulunamadiException;
import Exception.GecersizApiKeyException;

import Core.IEntityRepository;
import Entity.HavaDurumu;

import java.io.IOException;

public interface IHavaDurumuDal extends IEntityRepository<HavaDurumu> {
    HavaDurumu getWeatherDescription(HavaDurumu havaDurumu, String sehirAdi) throws IOException, SehirBulunamadiException, GecersizApiKeyException;
}
