package frontend;

import backend.*;

import java.util.Scanner;

public class SiparisUI {

    Scanner scanner=new Scanner(System.in);
    private Kahve kahve;
    public void siparisAl(){
        kahveSec();
        sutSor();
        sekerSor();
        boySor();

        kahve.setFiyat();

        System.out.println("********************************");
        System.out.printf("%s %s hazır. \n",kahve.getBoy(),kahve.getCesit());
        System.out.printf("Borcunuz %d Tl efendim.\n",kahve.getFiyat());
        System.out.printf("%s müessesemizin ikramıdır\n",kahve.ikramEkle());
        System.out.printf("Afiyet Olsun");
        System.out.println("********************************");
    }



    private void kahveSec(){
        String hagiKahve;
        boolean flag=true;

        do {
            System.out.println("Hangi Kahveyi istersiniz \n 1-Türk Kahvesi \n 2-Filtre Kahve \n 3-Ekspresso\n 4-Cappucino\n--------");
            System.out.println("Seçiminiz: ");
            hagiKahve=scanner.nextLine().toLowerCase().trim();
            switch (hagiKahve){
                case "türk kahvesi":
                case "filtre kahve":
                case "ekpresso":
                case "cappucino":
                    flag=true;
                    break;
                    default:
                        System.out.println("\n--------\n Hatalı giriş yaptınız.\n---------\n");
            }
        }while (flag);

        System.out.println("\n-------------------");
        System.out.println(hagiKahve+ " hazırlanıyor");
        System.out.println("\n-------------------");
        kahve=KahveProvider.KahveOlustur(hagiKahve);
        kahve.setCesit(hagiKahve);

    }

    private void sutSor(){
        boolean flag=true;

        do {

            System.out.println("Süt eklememizi istermisiniz? (Evet /Hayır)");
            String sut = scanner.next();

            if (sut.equalsIgnoreCase("Evet")) {
                System.out.println("\n ------------\nSüt ekleniyor\n---------------\n");
                kahve.setSutlu(true);
                flag = false;
            } else if (sut.equalsIgnoreCase("Hayır")) {
                System.out.println("\n----------\nSut eklenmiyor\n---------------\n");
                flag=false;
            }else {
                System.out.println("\n----------\nHatallı Giriş yaptınız\n----------\n");
            }
        }while (flag);

    }

    private void sekerSor(){
        boolean flag=true;

        do {

            System.out.println("Şeker eklememizi istermisiniz? (Evet /Hayır)");
            String seker = scanner.next();

            if (seker.equalsIgnoreCase("Evet")) {
                System.out.println("Kaç Şeker: ");
                int kacSeker=scanner.nextInt();
                System.out.println("\n ------------\n"+kacSeker+" şeker ekleniyor\n---------------\n");
                kahve.setSutlu(true);
                flag = false;
            } else if (seker.equalsIgnoreCase("Hayır")) {
                System.out.println("\n----------\nŞeker eklenmiyor\n---------------\n");
                flag=false;
            }else {
                System.out.println("\n----------\nHatallı Giriş yaptınız\n----------\n");
            }
        }while (flag);

    }

    private void boySor(){
        scanner.nextLine();//boş dummy
        boolean flag=true;

        do {

            System.out.println("Hangi boyut olsun Büyük boy-orta boy-küçük boy");
            String kahveBoyut = scanner.nextLine().toLowerCase().trim();

           switch (kahveBoyut){
               case "büyük boy":
               case "orta boy":
               case "küçük boy":
                   System.out.println("\n----------\nKahveniz "+ kahveBoyut+" hazırlanıyor\n---------\n");
                   kahve.setBoy(kahveBoyut);
                   flag=false;
                   break;
               default:
                   System.out.println("\n----------\nHatalı giriş yaptınız.\n---------\n");
           }
        }while (flag);

    }






}
