package Main;

import DataAccess.HavaDurumuDal;
import Business.DataManager;
import Entity.HavaDurumu;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String alinanSehirAdi;

        DataManager dataManager = new DataManager(new HavaDurumuDal());

        System.out.println("Hava durumunu öğrenmek istediğiniz şehrin adını string olarak yazınız.");
        alinanSehirAdi = scan.next();

        HavaDurumu havaDurumu = new HavaDurumu();
        dataManager.getWeatherDescription(havaDurumu, alinanSehirAdi);

        System.out.println("Anlık hava durumu => " + havaDurumu.getDescription());
    }
}