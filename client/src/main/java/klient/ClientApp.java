package klient;

import kontroler.KontrolerKlienta;
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
        kontrolerKlienta.podłączSię("Test");

        Thread.sleep(2000);
        System.out.println("poczkałem 2 sek");
        Thread.sleep(2000);
        kontrolerKlienta.pobierzPlanszę(5);

        try {
            kontrolerKlienta.odłączSię();
        } catch (NieJesteśPodłączonyException e) {
            System.out.println("nie byles podlaczony");
        }




    }

}

