package kontrola.modele;

import java.io.Serializable;

public class Wiadomosc implements Serializable {
    public String tresc;

    public Wiadomosc(String tresc) {
        this.tresc = tresc;
    }
}
