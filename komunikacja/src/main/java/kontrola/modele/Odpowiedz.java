package kontrola.modele;

import java.io.Serializable;
import java.util.Objects;

public class Odpowiedz implements Serializable {

    private int numerPotwierdzenia;
    private String wiadomość;
    private Object zawartosc;


    public Odpowiedz(int numerPotwierdzenia) {
        this.numerPotwierdzenia = numerPotwierdzenia;
        this.wiadomość = "OK";
    }


    public Odpowiedz(String wiadomość) {
        this.wiadomość = wiadomość;
    }

    public Object getZawartosc() {
        return zawartosc;
    }

    public void setZawartosc(Object zawartosc) {
        this.zawartosc = zawartosc;
    }

    public String getWiadomość() {
        return wiadomość;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Odpowiedz)) return false;
        Odpowiedz that = (Odpowiedz) o;
        return numerPotwierdzenia == that.numerPotwierdzenia &&
                Objects.equals(wiadomość, that.wiadomość);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerPotwierdzenia, wiadomość);
    }

    @Override
    public String toString() {
        return "Odpowiedz{" +
                "numerPotwierdzenia=" + numerPotwierdzenia +
                ", wiadomość='" + wiadomość + '\'' +
                '}';
    }
}
