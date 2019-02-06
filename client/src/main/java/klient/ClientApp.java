package klient;

import kontrola.modele.Odpowiedz;
import kontrola.modele.OpisPlanszy;
import kontroler.KontrolerKlienta;
import wyjątki.NieJesteśPodłączonyException;

import java.io.IOException;

public class ClientApp
{

    public static void main(String[] args) throws InterruptedException, NieJesteśPodłączonyException, IOException {


        KontrolerKlienta kontrolerKlienta = new KontrolerKlienta();
        Thread.sleep(1000);
        System.out.println("poczkałem sekunde sek");
        Odpowiedz odp =  kontrolerKlienta.podłączSię("Test");

        Thread.sleep(2000);
        Odpowiedz odp2 = kontrolerKlienta.pobierzPlanszę(5);
        var obj = (OpisPlanszy) odp2.getZawartosc();
        System.out.println("Plansza wygląda tak: " +obj.getPlansza());

//        try {
//            kontrolerKlienta.odłączSię();
//        } catch (NieJesteśPodłączonyException e) {
//            System.out.println("nie byles podlaczony");
//        }

    }

}

