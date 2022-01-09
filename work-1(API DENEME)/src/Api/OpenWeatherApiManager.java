package Api;

import Exception.SehirBulunamadiException;
import Exception.GecersizApiKeyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenWeatherApiManager implements IOpenWeatherApiService {
    private static HttpURLConnection connection; //zayıf bağımlılık
    String datasFromApi;

    //functions
    public String getDataFromApi(String sehirAdi) throws IOException {
        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();

        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/" +
                    "weather?q=" + sehirAdi + "&" +
                    "appid=b3ecc9765ddf97f7fd57765bfd77c476");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(10000);
            int status = connection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            datasFromApi = responseContent.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return datasFromApi;
    }

    public String getWeatherDescription(String sehirAdi) throws IOException, GecersizApiKeyException, SehirBulunamadiException {
        String apiString = getDataFromApi(sehirAdi);

        if (apiString.contains("city not found")) throw new SehirBulunamadiException("Şehir bulunamadı!");
        if (apiString.contains("Invalid API key")) throw new GecersizApiKeyException("Geçersiz Api Key!");

        int descriptionIndex = apiString.indexOf("description");
        String withoutBeforeDescription = apiString.substring(descriptionIndex);
        int nextColonIndex = withoutBeforeDescription.indexOf(":");
        int nextCommaIndex = withoutBeforeDescription.indexOf(",");
        String onlyDescription = withoutBeforeDescription.substring(nextColonIndex + 2, nextCommaIndex - 1);

        return onlyDescription;
    }
}
