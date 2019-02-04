package klient;

import java.io.Serializable;

public class ObiektDoPrzesyłania implements Serializable {
    Object o;
    String klasa;
    String polecenie;


    public ObiektDoPrzesyłania(Object o, String klasa, String polecenie) {
        this.o = o;
        this.klasa = klasa;
        this.polecenie = polecenie;
    }

    @Override
    public String toString() {
        return "ObiektDoPrzesyłania{" +
                "o=" + o +
                ", klasa='" + klasa + '\'' +
                ", polecenie='" + polecenie + '\'' +
                '}';
    }
}
