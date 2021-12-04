package Api;

import java.io.IOException;

public interface IOpenWeatherApiService {
    String getDataFromApi(String sehirAdi) throws IOException;
    String getWeatherDescription(String sehirAdi) throws  IOException;
}
