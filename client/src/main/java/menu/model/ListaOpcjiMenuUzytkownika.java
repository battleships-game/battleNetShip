package menu.model;

import menu.funkcjonalnosci_menu.KontrolerMenuUzytkownika;
import menu.OpcjaMenu;

import java.util.ArrayList;
import java.util.List;

class ListaOpcjiMenuUzytkownika extends ListaOpcjiMenu{

     ListaOpcjiMenuUzytkownika() {
        this.utworzOpcjeMenu();
    }

    private void utworzOpcjeMenu() {
        List<OpcjaMenu> opcjeMenu = new ArrayList<>();
        opcjeMenu.add(new OpcjaMenu("Pobierz plansze", ()-> new KontrolerMenuUzytkownika().pobierzPlansze()));
        opcjeMenu.add(new OpcjaMenu("Wyswietl innych userow", ()-> new KontrolerMenuUzytkownika().wyswietlUserow()));
        this.setOpcjeMenu(opcjeMenu);
    }

}
