package modele;

public class Odpowiedź {

    String msg;

    Object object;

    public Odpowiedź(String msg) {
    this.msg =msg;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
