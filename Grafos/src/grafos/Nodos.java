package grafos;

import java.util.ArrayList;

public class Nodos {
    private boolean esSource;
    private String key;
    private boolean fueEvaluado;
    private String keyNodoPadre;
    private double acum;
    
    public Nodos(String key){
        this.key=key;
        this.esSource=false;
        this.fueEvaluado=true;
        this.keyNodoPadre="";
        this.acum=Double.POSITIVE_INFINITY;
    }

    public double getAcum() {
        return acum;
    }

    public void setAcum(double acum) {
        this.acum = acum;
    }

    public boolean isEsSource() {
        return esSource;
    }

    public void setEsSource(boolean esSource) {
        this.esSource = esSource;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isFueEvaluado() {
        return fueEvaluado;
    }

    public void setFueEvaluado(boolean fueEvaluado) {
        this.fueEvaluado = fueEvaluado;
    }

    public String getKeyNodoPadre() {
        return keyNodoPadre;
    }

    public void setKeyNodoPadre(String keyNodoPadre) {
        this.keyNodoPadre = keyNodoPadre;
    }
    
}
