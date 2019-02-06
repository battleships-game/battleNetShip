package klient;

import kontrola.modele.OpisPlanszy;
import kontroler.KontrolerKlienta;
import modele.Odpowiedź;
import przesył.Przesyłacz;
import wyjątki.NieJesteśPodłączonyException;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp
{

    public static void main(String[] args) throws InterruptedException, NieJesteśPodłączonyException, IOException {


        KontrolerKlienta kontrolerKlienta = new KontrolerKlienta();
        Thread.sleep(1000);
        System.out.println("poczkałem sekunde sek");
        Odpowiedź odp =  kontrolerKlienta.podłączSię("Test");

        Thread.sleep(2000);
        Odpowiedź odp2 = kontrolerKlienta.pobierzPlanszę(5);
        var obj = (OpisPlanszy) odp2.getObject();
        System.out.println("Plansza wygląda tak: " +obj.getPlansza());

//        try {
//            kontrolerKlienta.odłączSię();
//        } catch (NieJesteśPodłączonyException e) {
//            System.out.println("nie byles podlaczony");
//        }

    }

}

