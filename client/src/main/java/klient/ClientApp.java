package klient;

import io.Drukarka;
import io.Wczytywacz;
import kontroler.KontrolerKlienta;
import lang.Language;
import lang.Languages;
import menu.Menu;
import menu.RodzajMenu;
import wyjątki.NieJesteśPodłączonyException;

import java.io.IOException;
import java.util.ResourceBundle;


public class ClientApp {

    public static void main(String[] args) throws InterruptedException, IOException {

        KontrolerKlienta kontrolerKlienta = new KontrolerKlienta();
        Language.getInstance().setLanguage(Languages.POLISH);

        // TODO: sprawdzanie czy jest podłączony i w zależności od tego wyświetlić odpowiednie menu
        Menu menu = new Menu(ResourceBundle.getBundle(Language.getInstance().getLanguage()), RodzajMenu.GLOWNE, kontrolerKlienta);

        while (!kontrolerKlienta.czyPodłączony()) {


            Wczytywacz wczytywacz = new Wczytywacz();
            Drukarka drukarka = new Drukarka();
            drukarka.println(menu.pobierzMenu());

            int id = Integer.valueOf(wczytywacz.wczytaj());
            menu.pobierzFunkcjonalnosc(id).wykonaj();
        }

        try {
            kontrolerKlienta.odłączSię();
        } catch (NieJesteśPodłączonyException e) {
            System.out.println("nie byles podlaczony");
        }


    }
}

