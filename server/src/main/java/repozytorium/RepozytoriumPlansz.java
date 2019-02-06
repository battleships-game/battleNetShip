package repozytorium;

import repozytorium.Plansza;

import java.util.HashMap;

public class RepozytoriumPlansz {
    HashMap<Integer, Plansza> listaPlansz;

    public RepozytoriumPlansz(){
        inicjalizujPlansze();
    }

    private void inicjalizujPlansze(){
        listaPlansz=new HashMap<>();
        for(int i=0; i<9; i++){
            listaPlansz.put(i,new Plansza("OOOOOOOOO"));
        }
    }

    public Plansza wezPlansze(int id){
        if(listaPlansz.containsKey(id)){
            return listaPlansz.get(id);
        }
        else throw new IllegalArgumentException();
    }

    public void dodajPlansze(Plansza plansza){
    }


}
