package menu.model;

import kontroler.KontrolerKlienta;
import menu.funkcjonalnosci_menu.KontrolerMenuGlowne;
import menu.OpcjaMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

class ListaOpcjiMenuGlownego extends ListaOpcjiMenu {
        private KontrolerMenuGlowne kontrolerMenuGlowne;
     ListaOpcjiMenuGlownego(KontrolerKlienta kontrolerKlienta) {
        this.utworzOpcjeMenu();
        this.kontrolerMenuGlowne = new KontrolerMenuGlowne(kontrolerKlienta);
    }

    private void utworzOpcjeMenu() {
        List<OpcjaMenu> opcjeMenu = new ArrayList<>();
        opcjeMenu.add(new OpcjaMenu(ResourceBundle.getBundle("Language_pl").getString("connect"), ()-> kontrolerMenuGlowne.podlaczDoSerwera()));
        opcjeMenu.add(new OpcjaMenu("Opusc gre", ()-> kontrolerMenuGlowne.opuscGre()));
        this.setOpcjeMenu(opcjeMenu);
    }


}
