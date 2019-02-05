package kontroler;

import kontrola.ObiektDoPrzesyłania;
import kontrola.Polecenie;
import kontrola.modele.OpisPlanszy;
import kontrola.modele.Uzytkownik;
import przesył.Przesyłacz;
import wyjątki.NieJesteśPodłączonyException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class KontrolerKlienta {


    Przesyłacz przesyłacz;

    public KontrolerKlienta() {
    }


    public boolean podłączSię(String imię) throws InterruptedException, IOException {
        this.przesyłacz = Przesyłacz.getInstance();
        ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(new Uzytkownik(imię), Uzytkownik.class, Polecenie.PODŁĄCZ);
         przesyłacz.ślij(obiektDoPrzesyłania);
        return true;
    }

    public boolean odłączSię() throws NieJesteśPodłączonyException, InterruptedException {
        if(przesyłacz==null){
            throw new NieJesteśPodłączonyException();
        }
        ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(null ,null, Polecenie.OPUŚĆ);
        przesyłacz.ślij(obiektDoPrzesyłania);
        return true;
    }

    public String pobierzPlanszę(int numer) throws NieJesteśPodłączonyException, InterruptedException {
        if(przesyłacz==null){
            throw new NieJesteśPodłączonyException();
        }
        ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(new OpisPlanszy(numer), OpisPlanszy.class, Polecenie.POBIERZ_PLANSZĘ);
        przesyłacz.ślij(obiektDoPrzesyłania);
        return "OOOOOOOOO";
    }

    public List<String> pobierzKlientów() throws NieJesteśPodłączonyException, InterruptedException {
        if(przesyłacz==null){
            throw new NieJesteśPodłączonyException();
        }
        ObiektDoPrzesyłania obiektDoPrzesyłania = new ObiektDoPrzesyłania(null, null, Polecenie.POBIERZ_UŻYTKOWNIKÓW);
        przesyłacz.ślij(obiektDoPrzesyłania);
        return Arrays.asList("1. ADAM", "2. MARCIN", "3. PIOTREK");
    }
}
