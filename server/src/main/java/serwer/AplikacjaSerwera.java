package serwer;

import sterowanie.Kontroler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AplikacjaSerwera {
    public static void main(String[] args )
    {
        int iloscZalogowanych =0;
        Drukarka drukarka = new Drukarka();
        var kontroler = Kontroler.zwrocInstancje(drukarka);

        try (ServerSocket s = new ServerSocket(8888))
        {
            while (true)
            {
                Socket gniazdoKlienta = s.accept();
                drukarka.drukuj("Ktoś podłączył sie z portu : " + gniazdoKlienta.getPort());
                Runnable r = new ThreadedClientHandler(gniazdoKlienta, kontroler);
                Thread watekKlienta = new Thread(r, String.format("WątekKlienta:%s", gniazdoKlienta.getPort()));
                iloscZalogowanych++;
                drukarka.drukuj("tyle zalogowanych: " + iloscZalogowanych);
                watekKlienta.start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

