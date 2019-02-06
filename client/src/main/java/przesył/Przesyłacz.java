package przesył;

import klient.Klient;
import kontrola.ObiektDoPrzesyłania;
import kontrola.Polecenie;
import kontrola.modele.Odpowiedz;


import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Przesyłacz {

    static private volatile Przesyłacz przesyłacz;
    private Klient klient;
    public BlockingQueue<Odpowiedz> potwierdzenia = new ArrayBlockingQueue(10);

    final Object blk1 = new Object();
    final Object blk2 = new Object();


    public static Przesyłacz getInstance() throws IOException {
                if (przesyłacz == null) {
                    przesyłacz = new Przesyłacz();
            }
        return przesyłacz;
    }

    private Przesyłacz() throws IOException {
        this.klient = Klient.getInstance();
    }

    public Odpowiedz ślij(ObiektDoPrzesyłania obiektDoPrzesyłania) throws InterruptedException {
        synchronized (blk1){
        klient.wrzućDoKolejkiWysyłkowej(obiektDoPrzesyłania);
        Odpowiedz po  = new Odpowiedz(obiektDoPrzesyłania.getNumerZapytania());
        Odpowiedz uzyskane;
            System.out.println(potwierdzenia);
                while((uzyskane = potwierdzenia.poll(2, TimeUnit.SECONDS))!=null){
                    if (uzyskane.equals(po)){
                        return uzyskane;
                    }
        }
            System.out.println(potwierdzenia.size());
            System.out.println("Nie było nic w kolejce");
            return new Odpowiedz("Nie powiodło się");
    }}


    public void odbierz(ObiektDoPrzesyłania obiektPrzychodzący) {
        System.out.println("robie coś tutaj");
        synchronized (blk2){
        if(obiektPrzychodzący.getPolecenie().equals(Polecenie.POTWIERDZENIE_ODBIORU)){
            System.out.println("przyszyszło potwierdzenie odb");
            potwierdzenia.add((Odpowiedz) obiektPrzychodzący.getO());
            System.out.println("dodałem sobie PO");
        }
        else{
            System.out.println("Dostałem odpowiedz w postaci:");
            System.out.println(obiektPrzychodzący.getO().toString());
        }
        }
    }


}
