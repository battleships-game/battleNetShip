package klient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp
{

    public static void main(String[] args) throws IOException, InterruptedException {
//        ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(new Uzytkownik("Jan"), Uzytkownik.class, "PRZYWITANIE");
//        ObiektDoPrzesyłania obiektDoPrzesyłania2 = new ObiektDoPrzesyłania(new Uzytkownik("Roman"), Uzytkownik.class, "POŻEGNANIE");
        var socket = new Socket(InetAddress.getLocalHost(), 8888);
        Klient klient = new Klient(socket, new Scanner(System.in), KontrolerKlienta.zwrocInstance());
        klient.rozpocznijNasluchiwanie();
        klient.rozpocznijWysylanie();
//        Thread.sleep(5000);
//        System.out.println("Uwaga wysyłam obiekt");
//        Thread.sleep(1000);
//        var out = new ObjectOutputStream(socket.getOutputStream());
//        out.writeObject(obiektDoPrzesyłania);
//        Thread.sleep(1000);
//        out.writeObject(obiektDoPrzesyłania2);
//        System.out.println("Przesłałem pozdrawiam");



    }

}

