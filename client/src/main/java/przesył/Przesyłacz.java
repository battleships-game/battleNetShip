package przesył;

import klient.Klient;
import kontrola.ObiektDoPrzesyłania;
import kontrola.Polecenie;
import kontrola.modele.PotwierdzenieOdbioru;
import kontroler.KontrolerKlienta;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Przesyłacz {

    static private volatile Przesyłacz przesyłacz;
    private Klient klient;
    private BlockingQueue<PotwierdzenieOdbioru> potwierdzenia = new ArrayBlockingQueue(10);

    Object blk1 = new Object();
    Object blk2 = new Object();


    public static Przesyłacz getInstance() throws IOException {
                if (przesyłacz == null) {
                    przesyłacz = new Przesyłacz();
            }
        return przesyłacz;
    }

    private Przesyłacz() throws IOException {

        this.klient = Klient.getInstance();
    }

    public boolean ślij(ObiektDoPrzesyłania obiektDoPrzesyłania) throws InterruptedException {
        synchronized (blk1){
        klient.wrzućDoKolejkiWysyłkowej(obiektDoPrzesyłania);
        PotwierdzenieOdbioru po  = new PotwierdzenieOdbioru(obiektDoPrzesyłania.getNumerZapytania());
        PotwierdzenieOdbioru uzyskane;
            System.out.println("bede czekał 100s aż się pojawi");
                while((uzyskane = potwierdzenia.poll(10, TimeUnit.SECONDS))!=null){
                    System.out.println("poczekalem i się pojawiło");
                    System.out.println("uzyskane"+uzyskane.toString());
                    System.out.println("nasze"+po.toString());
                    if (uzyskane.equals(po)){
                        System.out.println("Mamy potwierdzenie odbioru" + uzyskane.toString());
                        return true;
                    }
        }
            System.out.println(potwierdzenia.size());
            System.out.println("Nie było nic w kolejce");
            return false;
    }}


    public void odbierz(ObiektDoPrzesyłania obiektPrzychodzący) {
        System.out.println("robie coś tutaj");
        synchronized (blk2){
        if(obiektPrzychodzący.getPolecenie().equals(Polecenie.POTWIERDZENIE_ODBIORU)){
            System.out.println("przyszyszło potwierdzenie odb");
            potwierdzenia.add((PotwierdzenieOdbioru) obiektPrzychodzący.getO());
            System.out.println("dodałem sobie PO");
        }
        else{
            System.out.println("Dostałem odpowiedz w postaci:");
            System.out.println(obiektPrzychodzący.getO().toString());
        }
        }
    }


}
