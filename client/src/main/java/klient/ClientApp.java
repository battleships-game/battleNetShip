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

//        var socket = new Socket("10.30.0.198", 8888);

        var socket = new Socket("127.0.0.1", 8888);
        var out = new ObjectOutputStream(socket.getOutputStream());

        for(int i = 0; i<1000; i++) {
//            ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(new Uzytkownik("'Andrzej "+args[0]+", po raz "+i+"'"), Uzytkownik.class, "PRZYWITANIE");
//            ObiektDoPrzesyłania obiektDoPrzesyłania2 = new ObiektDoPrzesyłania(new Uzytkownik("'Andrzej "+args[0]+", po raz "+i+"'"), Uzytkownik.class, "POŻEGNANIE");
//            ObiektDoPrzesyłania[] obiektDoPrzesyłanias = new ObiektDoPrzesyłania[]{obiektDoPrzesyłania, obiektDoPrzesyłania2};
            if(!socket.isClosed())
            {
                Thread.sleep(300);
//                int round = (int) Math.round(Math.random());
                if(i<999) {
                    ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(new Uzytkownik("'Andrzej "+args[0]+", po raz "+i+"'"), Uzytkownik.class, "PRZYWITANIE");
                    out.writeObject(obiektDoPrzesyłania);
                    System.out.println("Wątek nr: "+args[0]+". Przesłałem po raz " + i + " pozdrawiam ");
                }
                else {
                    ObiektDoPrzesyłania obiektDoPrzesyłania2 = new ObiektDoPrzesyłania(new Uzytkownik("'Andrzej "+args[0]+", po raz "+i+"'"), Uzytkownik.class, "POŻEGNANIE");
                    out.writeObject(obiektDoPrzesyłania2);
                    System.out.println("Wątek nr: "+args[0]+". Przesłałem po raz " + i + " pozdrawiam ");
                }
            }
            else
            {
                System.out.println("Socket "+args[0]+" przestał działać po "+i);
            }
        }
        out.close();
    }



}

