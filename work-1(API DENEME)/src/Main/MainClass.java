package Main;

import DataAccess.HavaDurumuDal;
import Business.DataManager;
import Entity.HavaDurumu;

import Exception.SehirBulunamadiException;
import Exception.GecersizApiKeyException;
import Exception.BoslukKontrolException;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws IOException, GecersizApiKeyException {
        Scanner scan = new Scanner(System.in);

        try {
            String alinanSehirAdi;

            DataManager dataManager = new DataManager(new HavaDurumuDal());

            System.out.println("Hava durumunu öğrenmek istediğiniz şehrin adını boşluksuz olarak yazınız.");
            alinanSehirAdi = scan.nextLine();

            if (alinanSehirAdi.contains(" ")) throw new BoslukKontrolException("Boşluklu ifade girmeyiniz!");

            HavaDurumu havaDurumu = new HavaDurumu();
            dataManager.getWeatherDescription(havaDurumu, alinanSehirAdi);

            System.out.println("Anlık hava durumu => " + havaDurumu.getDescription());
            System.out.println("Hava durumu nesnesinin kimliği => " + havaDurumu.toString());
        }catch(BoslukKontrolException exception) {
            exception.printStackTrace();
        }catch(SehirBulunamadiException exception) {
            exception.printStackTrace();
        }catch(GecersizApiKeyException exception) {
            exception.printStackTrace();
        }catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}