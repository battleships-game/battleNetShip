package klient;

import kontrola.ObiektDoPrzesyłania;

class KontrolerKlienta {
    private static KontrolerKlienta kontroler;

    private KontrolerKlienta() {

    }

    public static KontrolerKlienta zwrocInstance() {
        if (kontroler == null) {
            kontroler = new KontrolerKlienta();
        }
        return kontroler;
    }

    public ObiektDoPrzesyłania zapakuj(Object o, Class klasa, String polecenie) {
        return new ObiektDoPrzesyłania(o, klasa, polecenie);
    }

    public void rozpakuj(ObiektDoPrzesyłania obiektDoPrzesyłania) {
        if (obiektDoPrzesyłania.polecenie.equals("POTWIERDZENIE")) {
            System.out.println("Wiadomość dostarczona");
        }
    }
}
