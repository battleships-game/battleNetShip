package menu.funkcjonalnosci_menu;

import kontroler.KontrolerKlienta;

import java.io.IOException;

public class KontrolerMenuGlowne {

    private KontrolerKlienta kontrolerKlienta;

    public KontrolerMenuGlowne(KontrolerKlienta kontrolerKlienta) {
        this.kontrolerKlienta = kontrolerKlienta;
    }

    public boolean podlaczDoSerwera()
    {
        System.out.println("Podlaczamy do serwera");
        try {
            kontrolerKlienta.podłączSię("Kamil ciul znajdz se");
        } catch (InterruptedException | IOException e) {
            System.err.println("Nie udało się podłączyć do serwera");
            return false;
        }
        return true;
    }

    public boolean opuscGre()
    {
        System.out.println("Opuszczamy gre");
        return true;
    }

}
