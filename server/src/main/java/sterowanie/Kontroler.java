package sterowanie;

import kontrola.ObiektDoPrzesyłania;
import kontrola.modele.Uzytkownik;
import kontrola.modele.Wiadomosc;
import serwer.Drukarka;

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

    public void rozpakuj(ObiektDoPrzesyłania obiektDoPrzesyłania) {
        if(obiektDoPrzesyłania.polecenie.equals("PRZYWITANIE")){
            Uzytkownik u = (Uzytkownik) obiektDoPrzesyłania.o;
            drukarka.drukuj(String.format("dzień dobry, z tej strony uzytkownik o imieniu %s," +
                    "utworzony o czasie %s",u.getImie(), u.getCzasStworzenia() ));
        }
        if(obiektDoPrzesyłania.polecenie.equals("POŻEGNANIE")){
            drukarka.drukuj("Do widzenia");
        }
        if (obiektDoPrzesyłania.polecenie.equals("WIADOMOŚĆ")) {
            Wiadomosc w = (Wiadomosc) obiektDoPrzesyłania.o;
            drukarka.drukuj("Wiadomosc: " + w.tresc);
        }
    }





}
