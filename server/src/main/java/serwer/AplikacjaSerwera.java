package serwer;

import sterowanie.Kontroler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AplikacjaSerwera {
    public static void main(String[] args )
    {
        int iloscZalogowanych =0;
        var kontroler = Kontroler.getInstance();

        try (ServerSocket s = new ServerSocket(8888))
        {
            while (true)
            {
                Socket gniazdoKlienta = s.accept();
                System.out.println("Ktoś podłączył sie z portu : " + gniazdoKlienta.getPort());
                Runnable r = new ThreadedClientHandler(gniazdoKlienta, kontroler);
                Thread watekKlienta = new Thread(r, String.format("WątekKlienta:%s", gniazdoKlienta.getPort()));
                iloscZalogowanych++;
                System.out.println("tyle zalogowanych: " + iloscZalogowanych);
                watekKlienta.start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

