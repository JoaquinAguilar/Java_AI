package bellmanford;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {

    public static void main(String[] args) {
        BellmanFord d = new BellmanFord();
        d.algoritmo();
    }
    
    private Map<String, Nodo> Nodos;
    private List<Arista> lAristas;
    private double distancia;

    public BellmanFord() {
        lAristas = new ArrayList();
        Nodos = new HashMap();
    }
    
    public void setGrafo(){
        String[] V = new String[]{"A", "B", "C", "D", "E"};
        
        for(String v : V){
            Nodos.put(v, new Nodo(v));
        }
        
        
        lAristas.add(new Arista("A", "B", 7));
        lAristas.add(new Arista("A", "C", 6));
        lAristas.add(new Arista("B", "A", 1));
        lAristas.add(new Arista("B", "D", 5));
        lAristas.add(new Arista("C", "D", 5));
        lAristas.add(new Arista("D", "A", 8));
        lAristas.add(new Arista("D", "E", 2));
        lAristas.add(new Arista("E", "B", 4));
        lAristas.add(new Arista("E", "D", -10));
    }
    
    public void algoritmo(){
    
    
    
}
    public void setDistancias(Nodo ns, Arista arista){
        Nodo n1 = Nodos.get(arista.getKeyN1());
        Nodo n2 = Nodos.get(arista.getKeyN2());
      
        if(!n1.isSource() && !n1.isFueEvaluado() &&
                ns.getAcum()+arista.getCosto() <=  n1.getAcum()){
            Nodos.get(arista.getKeyN1()).setAcum(ns.getAcum() + arista.getCosto());
            Nodos.get(arista.getKeyN1()).setKeyNodoPadre(ns.getKey());
        }else if(!n2.isSource() && !n2.isFueEvaluado() &&
                ns.getAcum()+arista.getCosto() <=  n2.getAcum()){
            Nodos.get(arista.getKeyN2()).setAcum(ns.getAcum() + arista.getCosto());
            Nodos.get(arista.getKeyN2()).setKeyNodoPadre(ns.getKey());
        }
    }
    
    public void setDistanciaDigrago(Nodo ns, Arista arista){
        Nodo n2 = Nodos.get(arista.getKeyN2());
        if(!n2.isSource() && !n2.isFueEvaluado() &&
                ns.getAcum()+arista.getCosto() <=  n2.getAcum()){
            Nodos.get(arista.getKeyN2()).setAcum(ns.getAcum() + arista.getCosto());
            Nodos.get(arista.getKeyN2()).setKeyNodoPadre(ns.getKey());
        }
    }
}
