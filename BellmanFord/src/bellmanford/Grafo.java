package bellmanford;

public class Grafo {

    private int[][] adyacencia;
    private int n;
    
    public Grafo(int nodos){
        n = nodos;
        adyacencia = new int[nodos][nodos];
        //Llenar matriz
        for(int i = 0; i < nodos; i++){
            for(int j = 0; j < nodos; j++){
                adyacencia[i][j] = 0;
            }
        }
    }
    
    public void addArco(int nodo1, int nodo2){
        adyacencia[nodo1][nodo2] = 1;
        adyacencia[nodo2][nodo1] = 1;
    }
    
    public void removeArco(int nodo1, int nodo2){
        adyacencia[nodo1][nodo2] = 0;
        adyacencia[nodo2][nodo1] = 0;
    }
    
    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                s+= adyacencia[i][j]+" ";
            }
            s+="\n";
        }
        return s;
    }
    
}
