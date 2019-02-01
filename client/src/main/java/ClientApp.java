import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;

public class ClientApp
{

    public static void main(String[] args) throws IOException, InterruptedException {
        ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(new Osoba("Jan", "Nowak"), "Osoba", "Dodaj");
        ObiektDoPrzesyłania obiektDoPrzesyłania2 = new ObiektDoPrzesyłania(new Osoba("JAnek", "Hej"), "Osoba", "Usuń");
        var socket = new Socket(InetAddress.getLocalHost(), 8888);

        Thread.sleep(5000);
        System.out.println("Uwaga wysyłam obiekt");
        Thread.sleep(1000);
        var out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(obiektDoPrzesyłania);
        Thread.sleep(1000);
        out.writeObject(obiektDoPrzesyłania2);
        System.out.println("Przesłałem pozdrawiam");



    }

}

