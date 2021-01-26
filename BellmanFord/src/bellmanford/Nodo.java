package bellmanford;

public class Nodo {
    
    private String key;
    private boolean esSource;
    private boolean fueEvaluado;
    private String keyNodoPadre;
    private double acum;

    public Nodo(String key)
    {
        this.key = key;
        esSource = false;
        fueEvaluado = false;
        keyNodoPadre = "";
        acum = Double.POSITIVE_INFINITY;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isSource() {
        return esSource;
    }

    public void setIsSource(boolean es_source) {
        this.esSource = es_source;
    }

    public boolean isFueEvaluado() {
        return fueEvaluado;
    }

    public void setFueEvaluado(boolean fue_evaluado) {
        this.fueEvaluado = fue_evaluado;
    }

    public String getKeyNodoPadre() {
        return keyNodoPadre;
    }

    public void setKeyNodoPadre(String keyNodoPadre) {
        this.keyNodoPadre = keyNodoPadre;
    }

    public double getAcum() {
        return acum;
    }

    public void setAcum(double acum) {
        this.acum = acum;
    }
    
}
