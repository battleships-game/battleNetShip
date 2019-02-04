import menu.Menu;
import menu.Wczytywacz;


import java.io.*;
import java.util.*;

public class ClientApp
{

    public static void main(String[] args) throws IOException, InterruptedException {
        ResourceBundle resourceBundle= ResourceBundle.getBundle("Language_pl");
        Menu menu = new Menu(resourceBundle);
        Wczytywacz reader = new Wczytywacz();
        ObslugaClienta obslugaClienta = new ObslugaClienta();
        menu.menuPowitalne();
        obslugaClienta.parsuj(reader.wczytaj());
        
    }

}

