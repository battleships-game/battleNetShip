package menu;

import java.util.ResourceBundle;
import java.util.TreeMap;

public class Menu {
    private Drukarka printer = new Drukarka();
    private ResourceBundle resourceBundle;
    private TreeMap<Integer,String> mapaOpcji = KreatorMenu.zwrocMapeOpcji();

    public Menu(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public void menuPowitalne(){
        mapaOpcji.forEach((k,v)->printer.print(k+ " " +resourceBundle.getString(v)));
    }
}
