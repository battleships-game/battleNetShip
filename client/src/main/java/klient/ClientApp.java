package klient;


import kontrola.ObiektDoPrzesyłania;
import kontrola.modele.Uzytkownik;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientApp
{

    public static void main(String[] args) throws IOException, InterruptedException {
        ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(new Uzytkownik("Andrzej"), Uzytkownik.class, "PRZYWITANIE");
        var socket = new Socket(InetAddress.getLocalHost(), 8888);
//        for(int i = 0; i<100; i++) {
            Thread.sleep(1000);
            System.out.println("Uwaga wysyłam obiekt");
            Thread.sleep(1000);
            var out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(obiektDoPrzesyłania);
//        }
        System.out.println("Przesłałem pozdrawiam");
    }



}

