package grafos;

public class Arcos {

private String keyNodo1;
private String keyNodo2;
private double costo;

    public Arcos (String keyNodo1, String keyNodo2, double costo){
        this.keyNodo1=keyNodo1;
        this.keyNodo2=keyNodo2;
        this.costo=costo;
    }

    public String getKeyNodo1() {
        return keyNodo1;
    }

    public void setKeyNodo1(String keyNodo1) {
        this.keyNodo1 = keyNodo1;
    }

    public String getKeyNodo2() {
        return keyNodo2;
    }

    public void setKeyNodo2(String keyNodo2) {
        this.keyNodo2 = keyNodo2;
    }


}
