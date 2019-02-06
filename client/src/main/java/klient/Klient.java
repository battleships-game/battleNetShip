package klient;

import kontrola.ObiektDoPrzesyłania;
import kontrola.modele.PotwierdzenieOdbioru;
import kontrola.modele.Uzytkownik;
import kontrola.modele.Wiadomosc;
import przesył.Przesyłacz;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Klient {

    private static Klient instancja;

    private static Socket gniazdo;
    private BlockingQueue<ObiektDoPrzesyłania> kolejkaDoWysyłki = new ArrayBlockingQueue<>(10);
    private BlockingQueue<ObiektDoPrzesyłania> kolejkaDoOdbioru = new ArrayBlockingQueue<>(10);


    public static Klient getInstance() throws IOException {
        if(instancja==null){
            instancja = new Klient();
        }
        return instancja;
    }

    private Klient() throws IOException {
        this.gniazdo = new Socket(InetAddress.getLocalHost(),8888);
        rozpocznijSłuchanie();
        rozpocznijWysylanie();
    }

    void rozpocznijWysylanie() {
        Thread t = new Thread(()->{

            try (ObjectOutputStream wyjscie = new ObjectOutputStream(
                    gniazdo.getOutputStream())) {
                ObiektDoPrzesyłania paczka;
                while ((paczka = kolejkaDoWysyłki.poll(10, TimeUnit.DAYS)) !=null){
                    wyjscie.writeObject(paczka);
                }
            }
            catch (IOException | InterruptedException e){
                e.printStackTrace();
            }

        }, "wysyłaczKliencki");
        t.start();
    }


    public void wrzućDoKolejkiWysyłkowej(ObiektDoPrzesyłania obiektDoPrzesyłania) {
        kolejkaDoWysyłki.offer(obiektDoPrzesyłania);
    }

    void rozpocznijSłuchanie(){
        Thread t = new Thread(()->{
            try (InputStream inputStream = gniazdo.getInputStream();
                    ObjectInputStream wejscie = new ObjectInputStream(inputStream)) {
                ObiektDoPrzesyłania obiektPrzychodzący;
                while ((obiektPrzychodzący = (ObiektDoPrzesyłania) wejscie.readObject()) != null
                        && gniazdo.isConnected()) {
                    Przesyłacz.getInstance().odbierz(obiektPrzychodzący);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }, "słuchaczKliencki");
        t.start();
    }



}
