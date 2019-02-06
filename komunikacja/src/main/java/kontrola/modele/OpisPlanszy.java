package kontrola.modele;

import java.io.Serializable;

public class OpisPlanszy implements Serializable {
    int index;
    String plansza;

    public String getPlansza() {
        return plansza;
    }

    public OpisPlanszy(int index) {
        this.index = index;
        this.plansza = "OOOOOOOOOO";
    }

    public int getIndex() {
        return index;
    }

    public void setPlansza(String plansza) {
        this.plansza = plansza;
    }
}
