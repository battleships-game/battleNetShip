package kontrola;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class ObiektDoPrzesyłania implements Serializable {


    static AtomicInteger nextId = new AtomicInteger();


    private int numerZapytania;
    private Object o;
    private Class klasa;
    private Polecenie polecenie;



    public ObiektDoPrzesyłania(Object o, Class klasa, Polecenie polecenie) {
        this.numerZapytania = nextId.incrementAndGet();
        this.o = o;
        this.klasa = klasa;
        this.polecenie = polecenie;

    }

    public static AtomicInteger getNextId() {
        return nextId;
    }

    public int getNumerZapytania() {
        return numerZapytania;
    }

    public Object getO() {
        return o;
    }

    public Class getKlasa() {
        return klasa;
    }

    public Polecenie getPolecenie() {
        return polecenie;
    }

    @Override
    public String toString() {
        return "ObiektDoPrzesyłania{" +
                "numerZapytania=" + numerZapytania +
                ", o=" + o +
                ", klasa=" + klasa +
                ", polecenie=" + polecenie +
                '}';
    }
}
