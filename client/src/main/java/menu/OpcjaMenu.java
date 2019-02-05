package menu;

public class OpcjaMenu {
    private String etykieta;
    private Funkcjonalnosc funkcjonalnosc;

    public OpcjaMenu(String etykieta, Funkcjonalnosc funkcjonalnosc) {
        this.etykieta = etykieta;
        this.funkcjonalnosc = funkcjonalnosc;
    }

    public String getEtykieta() {
        return etykieta;
    }

    public Funkcjonalnosc getFunkcjonalnosc() {
        return funkcjonalnosc;
    }
}
