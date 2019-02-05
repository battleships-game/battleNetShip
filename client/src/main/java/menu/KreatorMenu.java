package menu;

import java.util.List;
import java.util.TreeMap;

class KreatorMenu {
     TreeMap<Integer, OpcjaMenu> zwrocMapeOpcji(List<OpcjaMenu> listaOpcjiMenu){
         TreeMap<Integer,OpcjaMenu> mapaOpcji = new TreeMap<>();
         for (int i = 0; i <listaOpcjiMenu.size() ; i++) {
             mapaOpcji.put(i, listaOpcjiMenu.get(i));
         }
         return mapaOpcji;
    }
}