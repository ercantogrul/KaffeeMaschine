package projects.KaffeMaschine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KahveMakinasi {
    ArrayList<String> kahveListesi = new ArrayList<>(Arrays.asList("Türk Kahvesi", "FiltreKahve", "Espresso"));
    ArrayList<String> kahveBoyLIstesi = new ArrayList<>(Arrays.asList("Kücük Boy", "Orta Boy", "Büyük Boy"));
    static String c_RED = "\u001B[31m";
    static String BOLD = "\033[0;1m";
    static String c_PURPLE = "\u001B[35m";
    static String c_GREEN = "\u001B[32m";
    int kahveSecimi;
    int kahveFiyat;
    int kahveBoy;
    String sutEklansinMi;
    String sekerEklensinMi;
    int kacSeker;
    int paraGirisi;

    static Scanner scan = new Scanner(System.in); // heryerde okuyabilmek icin static yaptik

    public void Kahvemiz() {
        System.out.println(BOLD + " ****Kahve Dünyasina hosgeldiniz****");
        System.out.println("           Fiyat Menüsü:\n" +
                "                    Küçük        Orta        Büyük\n" +
                "   1.Türk kahvesi   30Tl         40Tl          50Tl\n" +
                "   2.Latte          35Tl         45Tl          55Tl\n" +
                "   3.Espresso       40Tl         50Tl          60Tl\n" +
                "   * İlave Süt 10Tl");
    }

    public void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nHangi Kahveyi istersiniz? \n1-Türk Kahvesi \n2-Filtre Kahve \n3-Espresso \n4-Cikis");
        try {
            kahveSecimi = scan.nextInt();
            if (kahveSecimi < 1 || kahveSecimi > 4) {
                System.out.println("Hatali giris yaptiniz.");
                menu();
            }
            if (kahveSecimi == 1) {
                kahveFiyat = 30;
            } else if (kahveSecimi == 2) {
                kahveFiyat = 35;
            } else if (kahveSecimi == 3) {
                kahveFiyat = 40;
            } else if (kahveSecimi == 4) {
                System.out.println("cikis yaptiniz ");
                System.exit(0);
            } else {
                System.out.println("Hatali giris yaptiniz");
            }
        } catch (Exception e) {
            System.out.println("Hatali giris yaptiniz");
            menu();
        }
        kahveBoy();
    }

    public void kahveBoy() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hangi boy kahve istersiniz? \n1-Kücük boy \n2-Orta boy \n3-Büyük boy ");
        try {
            kahveBoy = scan.nextInt();
            if (kahveBoy < 1 || kahveBoy > 3) {
                System.out.println("Hatali giris yaptiniz");
                kahveBoy();
            }
            if (kahveBoy == 1) {
                System.out.println("Kücük boy " +kahveBoyLIstesi.get(kahveBoy-1)+ kahveListesi.get(kahveSecimi - 1) + " hazirlaniyor");
            } else if (kahveBoy == 2) {
                System.out.println("Orta boy " +kahveBoyLIstesi.get(kahveBoy-1)+ kahveListesi.get(kahveSecimi - 1) + " hazirlaniyor");
                kahveFiyat += 10;
            } else if (kahveBoy == 3) {
                System.out.println("Büyük boy " +kahveBoyLIstesi.get(kahveBoy-1)+ kahveListesi.get(kahveSecimi - 1) + " hazirlaniyor");
                kahveFiyat += 20;
            } else {
                System.out.println("Hatali giris yaptiniz");
            }
        } catch (Exception e) {
            System.out.println("Hatali giris yaptiniz");
            kahveBoy();
        }
        sutEkleme();

    }

    public void sutEkleme() {
        System.out.println("\nSüt eklemek istiyormusunuz ?\n(Evet icin \"E\" veya Hayir icin \"H\" olarak cevaplayiniz) :");
        sutEklansinMi = scan.next();
        if (sutEklansinMi.substring(0, 1).equalsIgnoreCase("E")) {
            sutEklansinMi = "Sütlü";
            kahveFiyat += 10;
            System.out.println("Kahvenize süt ekleniyor");
        } else if (sutEklansinMi.substring(0, 1).equalsIgnoreCase("H")) {
            sutEklansinMi = "Sütsüz";
            System.out.println("Süt eklenmiyor");
        } else {
            System.out.println("Hatali giris yaptiniz tekrar deneyiniz");
            sutEkleme();
        }
        sekerEkleme();
    }

    public void sekerEkleme() {
        System.out.println();
        System.out.println("Seker eklemek istiyormusunuz ?\n(Evet icin \"E\" veya Hayir icin \"H\" olarak cevaplayiniz) :");
        sekerEklensinMi = scan.next();

        if (sekerEklensinMi.substring(0, 1).equalsIgnoreCase("E")) {
            sekerEklensinMi = "Sekerli";
            System.out.println("Kac seker istersiniz :");
            try {
                kacSeker = scan.nextInt();
                if (kacSeker > 0 && kacSeker < 10) {
                    System.out.println("Kahvenize " + kacSeker + " seker ekleniyor");
                }
            }catch (Exception e) {
                System.out.println("Hatali giris yaptiniz");
                sekerEkleme();
            }

        } else if (sekerEklensinMi.substring(0, 1).equalsIgnoreCase("H")) {
            sekerEklensinMi = "Sekersiz";
            System.out.println("Seker eklenmiyor");
        } else {
            System.out.println("Hatali giris yaptiniz tekrar deneyiniz");
            sekerEkleme();
        }
        ucretMethodu();
    }


    public void ucretMethodu() {
        System.out.println();
        System.out.println("Kahve ücreti : " + kahveFiyat + " liradir");
        System.out.println("ücreti :  5-10-20-50'lik banknotlar olarak giriniz");
        paraGirisi = scan.nextInt();

        while (paraGirisi != kahveFiyat) {
            if (paraGirisi > kahveFiyat) {
                System.out.println("Para üstü " + Math.abs(kahveFiyat - paraGirisi) + " liradir lütfen aliniz");
                break;
            } else {
                System.out.println(kahveFiyat - paraGirisi + " lira eksik giris yaptiniz.lütfen kalan tutari tamamlayiniz");
                paraGirisi += scan.nextInt();
            }
        }
    }

    @Override
    public String toString() {
        return "***Siparisinizin Özeti*** : {" +
                " Kahve Secimi="+ kahveListesi.get(kahveSecimi - 1) +
                ", Kahve Boy=" + kahveBoyLIstesi.get(kahveBoy-1) +
                ", Süt Eklansin Mi='" + sutEklansinMi + '\'' +
                ", Seker Eklensin Mi='" + sekerEklensinMi + '\'' +
                ", Kac Seker=" + kacSeker +
                ", Kahve Fiyati=" + kahveFiyat +" liradir"+
                ", Para Girisi=" + paraGirisi +" lira"+
                ", Para Üstü=" + (paraGirisi-kahveFiyat) +" lira aldiniz"+
                '}';
    }
    public static void main(String[] args) {
        KahveMakinasi kahve = new KahveMakinasi();
        kahve.Kahvemiz();
        kahve.menu();  //diger methodlari POJO class icerisine sirayla eklendi

        System.out.println(kahve.sutEklansinMi+" "+kahve.sekerEklensinMi+" "+kahve.kahveBoyLIstesi.get(kahve.kahveBoy)+
                kahve.kahveListesi.get(kahve.kahveSecimi-1)+" hazirdir afiyet olsun ");
        System.out.println(kahve);


    }
}
