package Api;

import java.io.IOException;
import Exception.GecersizApiKeyException;
import Exception.SehirBulunamadiException;

public interface IOpenWeatherApiService {
    String getDataFromApi(String sehirAdi) throws IOException;
    String getWeatherDescription(String sehirAdi) throws IOException, GecersizApiKeyException, SehirBulunamadiException;
}
