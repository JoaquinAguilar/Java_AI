
package mrysi.lania.grafos;

import java.util.ArrayList;
import mrysi.lania.util.Arista;
import mrysi.lania.util.Nodo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author saul
 */
public class Dijkstra {
    
    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        d.algoritmo();
    }
    
    private Map<String, Nodo> Nodos;
    private List<Arista> lAristas;

    public Dijkstra() {
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
        
        
        Nodos.get("C").setIsSource(true);
        Nodos.get("C").setAcum(0);
    }
    
    
    public void algoritmo(){
        setGrafo();
         /*Se comienza a iterar los nodos hasta que todos sean evaluados*/
        while(getNodosNoEvaluados()>0){
            /* 1) obtengo el nodo inicial */
            Nodo nodoSource = getNodoSource();
            if(nodoSource!=null){
                    
                System.out.println("Source "+nodoSource.getKey());
                /* 2) buscar nodos adyacentes */
                List<Arista> adyacentes = getAdyacentesDigrafo(nodoSource.getKey());
                /* 3) calcular costos de ayacentes */
                for(Arista arista : adyacentes){
                    setDistanciasDigrafo(nodoSource, arista);
                }
                /* 4) el nodo origen anterior pasa a verificado */
                Nodos.get(nodoSource.getKey()).setIsSource(false);
                Nodos.get(nodoSource.getKey()).setFueEvaluado(true);
                /* 5) Seleccionar como source el Nodo con menor acumulado*/
                if(getNodosNoEvaluados()>0){
                    double minAcum = Double.POSITIVE_INFINITY;
                    String minKey = "";
                    for (Map.Entry<String, Nodo> nodo : Nodos.entrySet()) {
                        if(!nodo.getValue().isFueEvaluado()&&
                                nodo.getValue().getAcum()<=minAcum){
                            minAcum=nodo.getValue().getAcum();
                            minKey = nodo.getKey();
                        }
                    }
                    Nodos.get(minKey).setIsSource(true);
                }
                
            }
            
        }
    }
    
    public int getNodosNoEvaluados(){
        int NOevaluados=0;
        if(!Nodos.isEmpty()){
            for (Map.Entry<String, Nodo> nodo : Nodos.entrySet()) {
                if(!nodo.getValue().isFueEvaluado())
                    NOevaluados++;
            }
        }
        return NOevaluados;
    }
    
    public Nodo getNodoSource(){
        Nodo source = null;
        if(!Nodos.isEmpty()){
            for (Map.Entry<String, Nodo> nodo : Nodos.entrySet()) {
                if(nodo.getValue().isSource()){
                    source = nodo.getValue();
                    break;
                }
            }
        }
        return source;
    }
    
    public List<Arista> getAdyacentes(String key){
        List<Arista> adyacentes = new ArrayList();
        for (Arista arista : lAristas) {
            if(arista.getKeyN1().equals(key)||
                    arista.getKeyN2().equals(key)){
                adyacentes.add(arista);
            }
        }
        return adyacentes;
    }
    
    public List<Arista> getAdyacentesDigrafo(String key){
        List<Arista> adyacentes = new ArrayList();
        for (Arista arista : lAristas) {
            if(arista.getKeyN1().equals(key)){
                adyacentes.add(arista);
            }
        }
        return adyacentes;
    }
    
    public void setDistancias(Nodo ns, Arista arista){
        Nodo n1 = Nodos.get(arista.getKeyN1());
        Nodo n2 = Nodos.get(arista.getKeyN2());
        /*
          En esta implementación se estan considerando grafos no dirigidos.
          Por lo tanto, se verifican ambos nodos de la lista de adyacentes
        */
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
    
    public void setDistanciasDigrafo(Nodo ns, Arista arista){
        Nodo n2 = Nodos.get(arista.getKeyN2());
        /*
          En esta implementación se estan considerando grafos dirigidos
        */
        if(!n2.isSource() && !n2.isFueEvaluado() &&
                ns.getAcum()+arista.getCosto() <=  n2.getAcum()){
            Nodos.get(arista.getKeyN2()).setAcum(ns.getAcum() + arista.getCosto());
            Nodos.get(arista.getKeyN2()).setKeyNodoPadre(ns.getKey());
        }
    }
    
}
