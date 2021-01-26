package neuronaand;

import java.util.ArrayList;
import java.util.List;

/**
 * Código de una neurona que determina la puerta lógica AND
 * Se ocupa la regla de DELTA para el aprendizaje de la neurona
 * @author saul
 */
public class NeuronaAND {

    public static void main(String[] args) {
        
        List<int[]> x = new ArrayList();
        x.add(new int[]{1, -1, -1}); /*control, x1, x2*/
        x.add(new int[]{1, -1, 1});
        x.add(new int[]{1, 1, -1});
        x.add(new int[]{1, 1, 1});
        
        int[] d = new  int[]{-1, -1, -1, 1};
        double[][] w = new double[][]{{0, 0, 0}};
        
        System.out.println("Pesos Iniciales");
        for(int j = 0; j < w[0].length;j++){
            System.out.println("w"+j+" = "+w[0][j]);
        }
        
        /*Entrenamiento*/
        double Net = 0; //activación
        double y = 0;  //salida
        double tol = 0.05;
        boolean stopTraining = false;
        int t = 0;
        /*Ciclo de entrenamiento*/
        System.out.println("= FASE - ENTRENAMIENTO =");
        while(!stopTraining){
            /*Recorrido de las muestras de entrenamiento*/
            //System.out.println("EPOCA: "+(t+1));
            for(int i = 0; i < x.size(); i++){
                //System.out.println("\tEntradas: "+x.get(i)[0]+" ("+x.get(i)[1]+", "+x.get(i)[2]+")");
                /*Activación*/
                //System.out.print("\tActivación: ");
                Net = (x.get(i)[0]*w[0][0]) + (x.get(i)[1]*w[0][1]) + (x.get(i)[2]*w[0][2]);
                //System.out.println("("+x.get(i)[0]+" * "+w[0][0]+") + ("+x.get(i)[1]+" * "+w[0][1]+") + ("+x.get(i)[2]+" * "+w[0][2]+") = "+Net);
                /*salida*/
                y = transferencia(Net);
                //System.out.println("\tSalida: "+y);
                /*aprendizaje*/
                double alpha = 0.05;
                double error = d[i]-y;
                //System.out.println("\tAprendizaje");
                for(int j = 0; j < w[0].length; j++){
                    w[0][j] += alpha* x.get(i)[j] * error * (1+y) * (1-y);
                    //System.out.println(w[0][j]);
                }
                
            }
            
            /*Obtener error medio*/
            double sum = 0;
            for(int i = 0; i < x.size(); i++){
                Net = (x.get(i)[0]*w[0][0]) + (x.get(i)[1]*w[0][1]) + (x.get(i)[2]*w[0][2]);
                y = transferencia(Net);
                sum+= Math.pow((d[i]-y), 2);
            }
            System.out.println((t+1)+" "+sum);
            if(sum<=tol){
                stopTraining = true;
            }
            t++;
            //System.out.println("\n");
        }
        System.out.println("\n\n");
        System.out.println("= FASE - PRUEBA =");
        for(int i = 0; i < x.size(); i++){
            /*Activación*/
            Net = (x.get(i)[0]*w[0][0]) + (x.get(i)[1]*w[0][1]) + (x.get(i)[2]*w[0][2]); 
            /*salida*/
            y = transferencia(Net);
            System.out.println("("+x.get(i)[1]+", "+x.get(i)[2]+"): "+Math.round(y));
        }
    }
    
    /*Sigmoide Suavizada*/
    private static double transferencia(double net){
        double exp = Math.exp(-net);
        return (1-exp)/(1+exp);
    }
    
    
    
}
