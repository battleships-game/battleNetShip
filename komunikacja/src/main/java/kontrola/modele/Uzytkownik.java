package kontrola.modele;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Uzytkownik implements Serializable {

    String imie;
    LocalDateTime czasStworzenia;

    public Uzytkownik(String imie) {
        this.imie = imie;
        this.czasStworzenia= LocalDateTime.now();
    }

    public String getImie() {
        return imie;
    }

    public LocalDateTime getCzasStworzenia() {
        return czasStworzenia;
    }
}
