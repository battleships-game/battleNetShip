package menu.model;

import menu.RodzajMenu;
import menu.OpcjaMenu;

import java.util.HashMap;
import java.util.List;

public class MapaListOpcjiMenuGłównego {

    private HashMap<RodzajMenu, ListaOpcjiMenu> mapaOpcji;

    public MapaListOpcjiMenuGłównego() {
        this.mapaOpcji = new HashMap<>();
        mapaOpcji.put(RodzajMenu.GLOWNE, new ListaOpcjiMenuGlownego());
        mapaOpcji.put(RodzajMenu.UZYTKOWNIKA, new ListaOpcjiMenuPlanszy());
        mapaOpcji.put(RodzajMenu.PLANSZY, new ListaOpcjiMenuUzytkownika());
    }

    public List<OpcjaMenu> getListaOpcjiDlaMenu(RodzajMenu rodzajMenu) {
        return this.mapaOpcji.get(rodzajMenu).getOpcjeMenu();
    }
}
