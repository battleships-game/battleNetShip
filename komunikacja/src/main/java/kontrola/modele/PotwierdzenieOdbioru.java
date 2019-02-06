package kontrola.modele;

import java.io.Serializable;
import java.util.Objects;

public class PotwierdzenieOdbioru implements Serializable {
    int numerPotwierdzenia;
    String wiadomość;

    public Object getOdpowiedz() {
        return odpowiedz;
    }

    public void setOdpowiedz(Object odpowiedz) {
        this.odpowiedz = odpowiedz;
    }

    Object odpowiedz;

    public PotwierdzenieOdbioru(int numerPotwierdzenia) {
        this.numerPotwierdzenia = numerPotwierdzenia;
        this.wiadomość = "OK";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PotwierdzenieOdbioru)) return false;
        PotwierdzenieOdbioru that = (PotwierdzenieOdbioru) o;
        return numerPotwierdzenia == that.numerPotwierdzenia &&
                Objects.equals(wiadomość, that.wiadomość);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerPotwierdzenia, wiadomość);
    }

    @Override
    public String toString() {
        return "PotwierdzenieOdbioru{" +
                "numerPotwierdzenia=" + numerPotwierdzenia +
                ", wiadomość='" + wiadomość + '\'' +
                '}';
    }

    public String getWiadomość() {
        return wiadomość;
    }
}
