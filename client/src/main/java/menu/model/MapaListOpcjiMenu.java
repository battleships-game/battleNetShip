package menu.model;

import kontroler.KontrolerKlienta;
import menu.RodzajMenu;
import menu.OpcjaMenu;

import java.util.HashMap;
import java.util.List;

public class MapaListOpcjiMenu {

    private HashMap<RodzajMenu, ListaOpcjiMenu> mapaOpcji;

    public MapaListOpcjiMenu(KontrolerKlienta kontrolerKlienta) {
        this.mapaOpcji = new HashMap<>();
        mapaOpcji.put(RodzajMenu.GLOWNE, new ListaOpcjiMenuGlownego(kontrolerKlienta));
        mapaOpcji.put(RodzajMenu.UZYTKOWNIKA, new ListaOpcjiMenuPlanszy());
        mapaOpcji.put(RodzajMenu.PLANSZY, new ListaOpcjiMenuUzytkownika());
    }

    public List<OpcjaMenu> getListaOpcjiDlaMenu(RodzajMenu rodzajMenu) {
        return this.mapaOpcji.get(rodzajMenu).getOpcjeMenu();
    }
}
