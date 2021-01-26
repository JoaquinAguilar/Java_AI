package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AlgoritmoBusquedaCiega {
    private Map<String, Nodos> Nodos;
    private List<Arcos>lArcos;
    private Stack<Nodos>pila;
    
    public AlgoritmoBusquedaCiega(){
        lArcos=new ArrayList();
        Nodos=new HashMap();
        pila=new Stack();
    }
    
    public void setGrafo(){
        Nodos.put("A", new Nodos("A"));
        Nodos.put("B", new Nodos("B"));
        Nodos.put("C", new Nodos("C"));
        Nodos.put("D", new Nodos("D"));
        Nodos.put("E", new Nodos("E"));
        Nodos.put("F", new Nodos("F"));
        Nodos.put("G", new Nodos("G"));
        Nodos.put("H", new Nodos("H"));
        
        lArcos.add(new Arcos("A","B",7));
        lArcos.add(new Arcos("B","C",2));
        lArcos.add(new Arcos("B","E",1));
        lArcos.add(new Arcos("C","F",2));
        lArcos.add(new Arcos("E","D",5));
        lArcos.add(new Arcos("E","F",3));
        lArcos.add(new Arcos("E","H",8));
        lArcos.add(new Arcos("H","G",5));
        lArcos.add(new Arcos("D","G",4));
        
        Nodos.get("C").setEsSource(true);
    }
    
    public void algoritmo(){
        setGrafo();
        while(getNodosEvaluados()>0){
            Nodos nodoSource=getNodoSource();
            /*Settear acum=0 para el nodo source*/
            /*Buscar nodos adyacentes*/
            /*Calcular costos de nodos adyacentes*/
            /*El nodo adyacente anterior pasa a verificado*/
            /*Seleccionar como source el nodo con menor acum*/
        }
    }
    
    public int getNodosEvaluados(){
        int NOevaluados=0;
        if(!Nodos.isEmpty()){
        for(Map.Entry<String, Nodos>nodo:Nodos.entrySet()){
            if(!nodo.getValue().isFueEvaluado())
                NOevaluados++;
        }
        }
        return NOevaluados;
    }
    
    public Nodos getNodoSource(){
        Nodos source=null;
        if(!Nodos.isEmpty()){
            for(Map.Entry<String, Nodos>nodo:Nodos.entrySet()){
                if(nodo.getValue().isEsSource()){
                    source=nodo.getValue();
                    break;
                }
            }
        }
        return source;
    }
    
    public List<Arcos>getAdyacentes(String key){
        List<Arcos>adyacentes=new ArrayList();
        for(Arcos a:lArcos){
            if(a.getKeyNodo1().equals(key)||a.getKeyNodo2().equals(key)){
            adyacentes.add(a);
            }
        }
        return adyacentes;
    }
}
