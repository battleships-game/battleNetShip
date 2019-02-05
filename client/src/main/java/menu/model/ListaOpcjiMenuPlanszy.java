package menu.model;

import menu.funkcjonalnosci_menu.KontrolerMenuPlanszy;
import menu.OpcjaMenu;

import java.util.ArrayList;
import java.util.List;

class ListaOpcjiMenuPlanszy extends ListaOpcjiMenu{

     ListaOpcjiMenuPlanszy() {
        this.utworzOpcjeMenu();
    }

    private void utworzOpcjeMenu() {
        List<OpcjaMenu> opcjeMenu = new ArrayList<>();
        opcjeMenu.add(new OpcjaMenu("Pobierz inna plansze", ()-> new KontrolerMenuPlanszy().pobierzInnaPlansze()));
        opcjeMenu.add(new OpcjaMenu("Zaznacz pole na aktualnej planszy", ()-> new KontrolerMenuPlanszy().zaznaczPole()));
        opcjeMenu.add(new OpcjaMenu("Wyswietl userow", ()-> new KontrolerMenuPlanszy().wyswietlUserow()));
        opcjeMenu.add(new OpcjaMenu("Opusc gre", ()-> new KontrolerMenuPlanszy().opuscGre()));
        this.setOpcjeMenu(opcjeMenu);
    }

}
