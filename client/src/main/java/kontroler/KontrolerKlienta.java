package kontroler;

import kontrola.ObiektDoPrzesyłania;
import kontrola.Polecenie;
import kontrola.modele.Odpowiedz;
import kontrola.modele.OpisPlanszy;
import kontrola.modele.Uzytkownik;
import przesył.Przesyłacz;
import wyjątki.NieJesteśPodłączonyException;

import java.io.IOException;
import java.util.List;

public class KontrolerKlienta {


    Przesyłacz przesyłacz;

    public KontrolerKlienta() {
    }


    public Odpowiedz podłączSię(String imię) throws InterruptedException, IOException {
        this.przesyłacz = Przesyłacz.getInstance();
        ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(new Uzytkownik(imię), Uzytkownik.class, Polecenie.PODŁĄCZ);
        return przesyłacz.ślij(obiektDoPrzesyłania);

    }

    public boolean odłączSię() throws NieJesteśPodłączonyException, InterruptedException {
        if(przesyłacz==null){
            throw new NieJesteśPodłączonyException();
        }
        ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(null ,null, Polecenie.OPUŚĆ);
        przesyłacz.ślij(obiektDoPrzesyłania);
        return true;
    }

    public Odpowiedz pobierzPlanszę(int numer) throws NieJesteśPodłączonyException, InterruptedException {
        if(przesyłacz==null){
            throw new NieJesteśPodłączonyException();
        }
        ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(new OpisPlanszy(numer), OpisPlanszy.class, Polecenie.POBIERZ_PLANSZĘ);
        return przesyłacz.ślij(obiektDoPrzesyłania);
    }

    public List<String> pobierzKlientów() throws NieJesteśPodłączonyException, InterruptedException {
        if(przesyłacz==null){
            throw new NieJesteśPodłączonyException();
        }
        ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(null, null, Polecenie.POBIERZ_UŻYTKOWNIKÓW);
        return  (List<String>) przesyłacz.ślij(obiektDoPrzesyłania).getZawartosc();
    }
}
