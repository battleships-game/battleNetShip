package sterowanie;

import kontrola.ObiektDoPrzesyłania;
import kontrola.modele.Uzytkownik;

public class Kontroler {

    private static Kontroler kontroler;

    private Kontroler() {
    }

    public static Kontroler getInstance() {
      if(kontroler==null){
          kontroler = new Kontroler();
      }
      return kontroler;
    }

    public void rozpakuj(ObiektDoPrzesyłania obiektDoPrzesyłania) {
        if(obiektDoPrzesyłania.polecenie.equals("PRZYWITANIE")){
            Uzytkownik u = (Uzytkownik) obiektDoPrzesyłania.o;
            System.out.println(String.format("dzień dobry, z tej strony uzytkownik o imieniu %s," +
                    "utworzony o czasie %s",u.getImie(), u.getCzasStworzenia() ));
        }
        if(obiektDoPrzesyłania.polecenie.equals("POŻEGNANIE")){
            System.out.println("Do widzenia");
        }
    }





}
