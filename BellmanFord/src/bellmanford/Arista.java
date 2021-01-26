package bellmanford;

public class Arista {
    private String keyN1;
    private String keyN2;
    private double costo;

    public Arista(String kn1, String kn2, double cost)
    {
        keyN1 = kn1;
        keyN2 = kn2;
        costo = cost;
    }

    public String getKeyN1() {
        return keyN1;
    }

    public void setKeyN1(String keyN1) {
        this.keyN1 = keyN1;
    }

    public String getKeyN2() {
        return keyN2;
    }

    public void setKeyN2(String keyN2) {
        this.keyN2 = keyN2;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}