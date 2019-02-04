package klient;

import kontrola.ObiektDoPrzesyłania;
import kontrola.modele.Uzytkownik;
import kontrola.modele.Wiadomosc;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

class Klient {
    private Socket gniazdo;
    private Scanner wejscieUzytkownika;
    private ObjectOutputStream wyjscie;
    private KontrolerKlienta kontrolerKlienta;

    public Klient(Socket gniazdo, Scanner wejscieUzytkownika, KontrolerKlienta kontrolerKlienta) throws IOException {
        this.gniazdo = gniazdo;
        this.wejscieUzytkownika = wejscieUzytkownika;
        this.wyjscie = new ObjectOutputStream(
                new BufferedOutputStream(gniazdo.getOutputStream()));
        this.kontrolerKlienta = kontrolerKlienta;
    }

    void rozpocznijWysylanie() {
        try (ObjectOutputStream wyjscie = new ObjectOutputStream(
                gniazdo.getOutputStream())) {

            System.out.print("Podaj swoje imię: ");
            String imie = wejscieUzytkownika.nextLine();
            Uzytkownik uzytkownik = new Uzytkownik(imie);
            ObiektDoPrzesyłania obiektDoPrzesyłania = kontrolerKlienta.zapakuj(
                    uzytkownik,
                    Uzytkownik.class,
                    "PRZYWITANIE"
            );
            wyjscie.writeObject(obiektDoPrzesyłania);
            String komunikat;
            boolean koniecKomunikacji = false;
            System.out.print(imie + ": ");
            while ((komunikat = wejscieUzytkownika.nextLine()) != null && !koniecKomunikacji) {
                System.out.print(imie + ": ");
                if (komunikat.equals("/quit")) {
                    koniecKomunikacji = true;
                    wyjscie.writeObject(
                            kontrolerKlienta.zapakuj(
                                    uzytkownik,
                                    Uzytkownik.class,
                                    "POŻEGNANIE"
                            ));
//                    gniazdo.close();
                } else {
                    wyjscie.writeObject(
                            kontrolerKlienta.zapakuj(
                                    new Wiadomosc(komunikat),
                                    Wiadomosc.class,
                                    "WIADOMOŚĆ"
                            ));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void rozpocznijNasluchiwanie() {
        new Thread(new NasluchiwaczWiadomosci(), "nasluchiwacz-klienta").start();
    }

    class NasluchiwaczWiadomosci implements Runnable {
        @Override
        public void run() {
            try (ObjectInputStream wejscie = new ObjectInputStream(
                            gniazdo.getInputStream())) {
                ObiektDoPrzesyłania obiektDoPrzesyłania;
                while ((obiektDoPrzesyłania = (ObiektDoPrzesyłania) wejscie.readObject()) != null
                        && gniazdo.isConnected()) {
                    kontrolerKlienta.rozpakuj(obiektDoPrzesyłania);
                    System.out.println(obiektDoPrzesyłania);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
