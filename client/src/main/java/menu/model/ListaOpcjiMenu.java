package menu.model;

import menu.OpcjaMenu;

import java.util.List;

abstract class ListaOpcjiMenu {

    private List<OpcjaMenu> opcjeMenu;


    protected void setOpcjeMenu(List<OpcjaMenu> opcjeMenu) {
        this.opcjeMenu = opcjeMenu;
    }

    public List<OpcjaMenu> getOpcjeMenu() {
        return opcjeMenu;
    }

}
