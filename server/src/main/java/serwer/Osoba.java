package serwer;

import java.io.Serializable;

public class Osoba implements Serializable {

    String imię;
    String nazwisko;


    public Osoba(String imię, String nazwisko) {
        this.imię = imię;
        this.nazwisko = nazwisko;
    }
}