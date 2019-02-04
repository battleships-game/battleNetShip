package klient;


import kontrola.ObiektDoPrzesyłania;
import kontrola.modele.Uzytkownik;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

public class ClientApp
{

    public static void main(String[] args) throws IOException, InterruptedException {
        ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(new Uzytkownik("Andrzej"), Uzytkownik.class, "PRZYWITANIE");
        ObiektDoPrzesyłania obiektDoPrzesyłania2 = new ObiektDoPrzesyłania(new Uzytkownik("Andrzej"), Uzytkownik.class, "POŻEGNANIE");
        ObiektDoPrzesyłania[] obiektDoPrzesyłanias = new ObiektDoPrzesyłania[]{obiektDoPrzesyłania, obiektDoPrzesyłania2};
        var socket = new Socket("10.30.0.198", 8888);
//        for(int i = 0; i<100; i++) {
        Thread.sleep(1000);
        int round = (int) Math.round(Math.random());
        var out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(obiektDoPrzesyłanias[round]);
//        }
        System.out.println("Przesłałem pozdrawiam" + round);
    }



}

