package menu.model;

import menu.funkcjonalnosci_menu.KontrolerMenuGlowne;
import menu.OpcjaMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

class ListaOpcjiMenuGlownego extends ListaOpcjiMenu {

     ListaOpcjiMenuGlownego() {
        this.utworzOpcjeMenu();
    }

    private void utworzOpcjeMenu() {
        List<OpcjaMenu> opcjeMenu = new ArrayList<>();
        opcjeMenu.add(new OpcjaMenu(ResourceBundle.getBundle("Language_pl").getString("connect"), ()-> new KontrolerMenuGlowne().podlaczDoSerwera()));
        opcjeMenu.add(new OpcjaMenu("Opusc gre", ()-> new KontrolerMenuGlowne().opuscGre()));
        this.setOpcjeMenu(opcjeMenu);
    }


}
