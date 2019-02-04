package klient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

class Kient {
    private Socket gniazdo;
    private Scanner wejscieUzytkownika;
    private ObjectOutputStream wyjscie;

    public Kient(Socket gniazdo, Scanner wejscieUzytkownika) throws IOException {
        this.gniazdo = gniazdo;
        this.wejscieUzytkownika = wejscieUzytkownika;
        this.wyjscie = new ObjectOutputStream(
                new BufferedOutputStream(gniazdo.getOutputStream()));
    }

    void rozpocznijNasluchiwanie() {
        new Thread(new NasluchiwaczWiadomosci(), "nasluchiwacz-klienta").start();
    }

    void rozpocznijWysylanie() {
        new Thread(new WysylaczWiadomosci(), "wysylacz-klienta").start();
    }

    class NasluchiwaczWiadomosci implements Runnable {
        @Override
        public void run() {
            try (ObjectInputStream wejscie = new ObjectInputStream(
                    new BufferedInputStream(
                            gniazdo.getInputStream()))){
                ObiektDoPrzesyłania obiektDoPrzesyłania;
                while ((obiektDoPrzesyłania = (ObiektDoPrzesyłania) wejscie.readObject())!= null
                        && gniazdo.isConnected()) {
                    System.out.println(obiektDoPrzesyłania);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    class WysylaczWiadomosci implements Runnable {

        @Override
        public void run() {
            try (ObjectOutputStream wyjscie = new ObjectOutputStream(
                    new BufferedOutputStream(gniazdo.getOutputStream()))) {
                String komunikat;
                boolean koniecKomunikacji = false;
                while ((komunikat = wejscieUzytkownika.nextLine() )!= null && !koniecKomunikacji) {
                    if (komunikat.equals("/quit")) {
                        koniecKomunikacji = true;
                        gniazdo.close();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
