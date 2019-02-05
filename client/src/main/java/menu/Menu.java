package menu;

import kontroler.KontrolerKlienta;
import menu.model.MapaListOpcjiMenu;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Menu implements IMenu {
    private ResourceBundle resourceBundle;
    private Map<Integer, OpcjaMenu> mapaOpcji;
    private RodzajMenu rodzajMenu;

    public Menu(ResourceBundle resourceBundle, RodzajMenu rodzajMenu, KontrolerKlienta kontrolerKlienta) {
        this.resourceBundle = resourceBundle;
        this.rodzajMenu = rodzajMenu;
        this.mapaOpcji = new KreatorMenu().zwrocMapeOpcji(new MapaListOpcjiMenu(kontrolerKlienta).getListaOpcjiDlaMenu(rodzajMenu));
    }

    @Override
    public List<String> pobierzMenu() {
        return mapaOpcji.entrySet().stream().map(x -> x.getKey().toString() + ".      " + x.getValue().getEtykieta()).collect(Collectors.toList());
    }

    @Override
    public Funkcjonalnosc pobierzFunkcjonalnosc(final int id) {
        return mapaOpcji.entrySet().stream().filter(x -> x.getKey().equals(id)).findFirst().get().getValue().getFunkcjonalnosc();
    }
}
