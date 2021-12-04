package Business;

import Entity.HavaDurumu;

import java.io.IOException;

public interface IDataService {
    HavaDurumu getWeatherDescription(HavaDurumu havaDurumu, String sehirAdi) throws IOException;
}
