package sterowanie;

import kontrola.ObiektDoPrzesyłania;
import kontrola.Polecenie;
import kontrola.modele.OpisPlanszy;
import kontrola.modele.Odpowiedz;
import kontrola.modele.Uzytkownik;
import serwer.Drukarka;
import serwer.ThreadedClientHandler;

public class Kontroler {

    private static Kontroler kontroler;
    private Drukarka drukarka;

    private Kontroler(Drukarka drukarka) {
        this.drukarka = drukarka;
    }

    public static Kontroler zwrocInstancje(Drukarka drukarka) {
      if(kontroler==null){
          kontroler = new Kontroler(drukarka);
      }
      return kontroler;
    }

    public void rozpakuj(ObiektDoPrzesyłania obiektDoPrzesyłania, ThreadedClientHandler threadedClientHandler) {
        if(obiektDoPrzesyłania.getPolecenie().equals(Polecenie.PODŁĄCZ)){
            Uzytkownik u = (Uzytkownik) obiektDoPrzesyłania.getO();
            drukarka.drukuj(String.format("dzień dobry, z tej strony uzytkownik o imieniu %s," +
                    "utworzony o czasie %s",u.getImie(), u.getCzasStworzenia() ));
            threadedClientHandler.dodajDoWysłania(new ObiektDoPrzesyłania(new Odpowiedz(obiektDoPrzesyłania.getNumerZapytania()), Odpowiedz.class, Polecenie.POTWIERDZENIE_ODBIORU));
        }
        if(obiektDoPrzesyłania.getPolecenie().equals(Polecenie.OPUŚĆ)){
            drukarka.drukuj("Do widzenia");
        }
        if (obiektDoPrzesyłania.getPolecenie().equals(Polecenie.POBIERZ_PLANSZĘ)) {
            OpisPlanszy op = (OpisPlanszy) obiektDoPrzesyłania.getO();
            drukarka.drukuj("Ktoś chciał pobrac planszę numer: " + op.getIndex());
            op.setPlansza("XXXXXXOXXX");

            var odpowiedz = new Odpowiedz(obiektDoPrzesyłania.getNumerZapytania());
            odpowiedz.setZawartosc(op);
            threadedClientHandler.dodajDoWysłania(new ObiektDoPrzesyłania(odpowiedz, Odpowiedz.class, Polecenie.POTWIERDZENIE_ODBIORU));
        }
    }





}
