class ObslugaClienta {

    void parsuj(String wybraneId) {
        int id;
        try {
            id = Integer.parseInt(wybraneId);
            wywolaj(id);
        } catch (NumberFormatException ex) {
            System.out.println("Złe dane");
        }
    }

    private void wywolaj(int id){
        switch(id){
            case 0 :
                this.podlaczDoSerwera();
                break;
            case 1 :
                this.wyswietlPlansze();
                break;
            case 2 :
                this.zapiszPlansze();
                break;
        }
    }

    private void podlaczDoSerwera(){
        System.out.println("podlacza");
    }

    private void wyswietlPlansze() {
        System.out.println("wyswietla");
    }

    private void zapiszPlansze() {
        System.out.println("zapisuje");
    }
}
