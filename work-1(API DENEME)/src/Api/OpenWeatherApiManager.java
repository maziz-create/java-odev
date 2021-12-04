package Api;

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
        BufferedReader reader; //zayıf bağımlılık
        String line; //gelen isteğin hepsini tek bir stringte toplayacağız.
        StringBuilder responseContent = new StringBuilder(); //gelen isteği topyekün atacağımız şey

        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/" +
                    "weather?q=" + sehirAdi + "&" +
                    "appid=15c98a52b38b3b0ab872038428fb7ffd");
            connection = (HttpURLConnection) url.openConnection();

            //request ' in ayarları
            connection.setRequestMethod("GET"); //get methodu yapacağız. veri alacağız yani.
            connection.setConnectTimeout(5000); //istek 5 saniyede gelmezse duracak.
            connection.setReadTimeout(5000); //okuma süremiz en fazla 5 saniye.
            int status = connection.getResponseCode(); //bize ne döndü? 200: başarılı, 400+: hata vs..

            System.out.println("İstek başarılı oldu mu => " + (status == 200 ? "EVET" : "HAYIR"));

            //hata oluşursa eğer, akışla birlikte gelen error mesajlarını reader değişkenine attık.
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

                while ((line = reader.readLine()) != null) { //responseden bir şeyler okudukça...
                    responseContent.append(line); // gelen line'ları += yapıyoruz. (Bizim senaryomuzda 1 adet geliyor. bütün isteği tek bir line'a alıyor.)
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

    public String getWeatherDescription(String sehirAdi) throws IOException {
        String apiString = getDataFromApi(sehirAdi);
        int descriptionIndex = apiString.indexOf("description");
        String withoutBeforeDescription = apiString.substring(descriptionIndex);
        int nextColonIndex = withoutBeforeDescription.indexOf(":");
        int nextCommaIndex = withoutBeforeDescription.indexOf(",");
        String onlyDescription = withoutBeforeDescription.substring(nextColonIndex + 2, nextCommaIndex - 1);

        return onlyDescription;
    }
}
