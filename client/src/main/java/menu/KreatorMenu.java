package menu;

import java.util.TreeMap;

public class KreatorMenu {
    static TreeMap<Integer,String> zwrocMapeOpcji(){
        TreeMap<Integer,String> mapaOpcji = new TreeMap<>();
        mapaOpcji.put(0, "connect");
        mapaOpcji.put(1, "showBoard");
        mapaOpcji.put(2, "save");
        return mapaOpcji;
    }
}
