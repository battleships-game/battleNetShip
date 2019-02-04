package kontrola;

import java.io.Serializable;

public class ObiektDoPrzesyłania implements Serializable {
    public Object o;
    Class klasa;
    public String polecenie;


    public ObiektDoPrzesyłania(Object o, Class klasa, String polecenie) {
        this.o = o;
        this.klasa = klasa;
        this.polecenie = polecenie;

    }
}
