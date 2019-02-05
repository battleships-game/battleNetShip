package menu;

import menu.model.MapaListOpcjiMenuGłównego;

import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Menu implements IMenu {
     ResourceBundle resourceBundle;
     TreeMap<Integer, OpcjaMenu> mapaOpcji;
     RodzajMenu rodzajMenu;

    public Menu(ResourceBundle resourceBundle, RodzajMenu rodzajMenu) {
        this.resourceBundle = resourceBundle;
        this.rodzajMenu = rodzajMenu;
        this.mapaOpcji = new KreatorMenu().zwrocMapeOpcji(new MapaListOpcjiMenuGłównego().getListaOpcjiDlaMenu(rodzajMenu));
    }

    @Override
    public List<String> pobierzMenu() {
        return mapaOpcji.entrySet().stream().map(x->x.getKey().toString() + ".      " + x.getValue().getEtykieta() ).collect(Collectors.toList());
    }

    @Override
    public Funkcjonalnosc pobierzFunkcjonalnosc(final int id) {
        return mapaOpcji.entrySet().stream().filter(x->x.getKey().equals(id)).findFirst().get().getValue().getFunkcjonalnosc();
    }
}
